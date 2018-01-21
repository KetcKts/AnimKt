package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation.RELATIVE_TO_SELF

import kotlinx.android.synthetic.main.fragment_translate_animation.view.*
import tech.ketc.animkt.core.anim.translateAnim


class TranslateAnimationFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_translate_animation, container, false)!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val content = view.content

        view.trans_x_button.setOnClickListener {
            content.startAnimation(translateAnim(RELATIVE_TO_SELF, 0f, RELATIVE_TO_SELF, -5f, RELATIVE_TO_SELF, 0f, RELATIVE_TO_SELF, 0f) {
                duration = 300
                interpolator = FastOutSlowInInterpolator()
                fillAfter = true
            })
        }

        view.trans_y_button.setOnClickListener {
            content.startAnimation(translateAnim(RELATIVE_TO_SELF, 0f, RELATIVE_TO_SELF, 0f, RELATIVE_TO_SELF, 0f, RELATIVE_TO_SELF, -5f) {
                duration = 300
                interpolator = FastOutSlowInInterpolator()
                fillAfter = true
            })
        }
    }
}