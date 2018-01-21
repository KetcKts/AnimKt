package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_alpha_animation.view.*
import tech.ketc.animkt.core.anim.listener
import tech.ketc.animkt.core.animator.animate
import tech.ketc.animkt.core.animator.fromAlpha
import tech.ketc.animkt.core.animator.toAlpha
import tech.ketc.animkt.extension.anim.fadeIn


class VPAAlphaAnimationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_alpha_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.fade_in_button.setOnClickListener {
            view.content.animate {
                duration = 300
                fromAlpha = 0f
                toAlpha = 1f
            }.start()

            view.startAnimation(fadeIn())
            view.startAnimation(fadeIn { duration = 500 })
            view.fadeIn { view.isClickable = true }
            view.animate()
                    .setDuration(300)
                    .alphaBy(0f)
                    .alpha(1f)
                    .start()
        }

        view.fade_out_button.setOnClickListener {
            view.content.animate {
                duration = 300
                fromAlpha = 1f
                toAlpha = 0f
            }.start()
        }
    }
}