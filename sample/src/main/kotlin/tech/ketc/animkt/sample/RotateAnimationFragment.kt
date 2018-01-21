package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.RotateAnimation
import tech.ketc.animkt.core.anim.rotateAnim
import kotlinx.android.synthetic.main.fragment_rotate_anim.view.*


class RotateAnimationFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_rotate_anim, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val defaultInit: RotateAnimation.() -> Unit = {
            duration = 300
            interpolator = FastOutSlowInInterpolator()
            fillAfter = true
        }


        view.rotate90_button.setOnClickListener {
            view.content.startAnimation(rotateAnim(0f, 90f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f, defaultInit))
        }

        view.rotate90reverse_button.setOnClickListener {
            view.content.startAnimation(rotateAnim(0f, -90f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f, defaultInit))
        }
    }
}