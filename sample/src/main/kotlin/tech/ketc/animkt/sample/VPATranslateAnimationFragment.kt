package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_translate_animation.view.*
import tech.ketc.animkt.core.animator.animate
import tech.ketc.animkt.core.animator.toXDelta
import tech.ketc.animkt.core.animator.toYDelta
import tech.ketc.animkt.core.util.dp

class VPATranslateAnimationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_translate_animation, container, false)!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val content = view.content

        view.trans_x_button.setOnClickListener {
            content.animate {
                duration = 300
                toXDelta = dp(context!!, -200f)
                interpolator = FastOutSlowInInterpolator()
            }
        }

        view.trans_y_button.setOnClickListener {
            content.animate {
                duration = 300
                toYDelta = dp(context!!, -250f)
                interpolator = FastOutSlowInInterpolator()
            }
        }
    }
}