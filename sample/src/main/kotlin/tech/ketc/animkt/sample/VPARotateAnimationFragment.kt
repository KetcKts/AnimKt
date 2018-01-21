package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewPropertyAnimator
import kotlinx.android.synthetic.main.fragment_rotate_anim.view.*
import tech.ketc.animkt.core.animator.animate
import tech.ketc.animkt.core.animator.toDegrees

class VPARotateAnimationFragment : Fragment() {

    private var isAnimate = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(R.layout.fragment_rotate_anim, container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val defaultInit: ViewPropertyAnimator.() -> Unit = {
            duration = 300
            interpolator = FastOutSlowInInterpolator()
        }


        view.rotate90_button.setOnClickListener {
            if (isAnimate) return@setOnClickListener
            isAnimate = true
            view.content.animate {
                defaultInit()
                withStartAction { isAnimate = false }
                toDegrees = 90f
            }
        }

        view.rotate90reverse_button.setOnClickListener {
            if (isAnimate) return@setOnClickListener
            isAnimate = true
            view.content.animate {
                defaultInit()
                withStartAction { isAnimate = false }
                toDegrees = -90f
            }
        }
    }

}