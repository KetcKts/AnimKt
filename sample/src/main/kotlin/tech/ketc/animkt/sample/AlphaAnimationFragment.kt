package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_alpha_animation.view.*
import tech.ketc.animkt.core.anim.alphaAnim
import tech.ketc.animkt.core.anim.listener
import tech.ketc.animkt.extension.view.util.invisible
import tech.ketc.animkt.extension.view.util.visible

class AlphaAnimationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_alpha_animation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.fade_in_button.setOnClickListener {
            view.content.startAnimation(alphaAnim(0f, 1f) {
                duration = 300
                fillAfter = true
            })
        }

        view.fade_out_button.setOnClickListener {
            view.content.startAnimation(alphaAnim(1f, 0f) {
                duration = 300
                fillAfter = true
            })
        }
    }
}