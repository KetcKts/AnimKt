package tech.ketc.animkt.sample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.ScaleAnimation

import kotlinx.android.synthetic.main.fragment_scale_anim.view.*
import tech.ketc.animkt.core.anim.listener
import tech.ketc.animkt.core.anim.scaleAnim
import tech.ketc.animkt.core.util.adjustDuration

class ScaleAnimationFragment : Fragment() {

    private var isCollapse = true
    private var isAnimate = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_scale_anim, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //default initializer of scale animation
        val defaultInit: ScaleAnimation.() -> Unit = {
            duration = adjustDuration(300, context!!)
            interpolator = FastOutSlowInInterpolator()
            fillAfter = true
        }

        view.expand_button.setOnClickListener {
            if (isCollapse && !isAnimate) {
                isAnimate = true
                view.content.startAnimation(scaleAnim(1f, 3f, 1f, 3f,
                        RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f, defaultInit).listener { isAnimate = false })
                isCollapse = false
            }
        }

        view.collapse_button.setOnClickListener {
            if (!isCollapse && !isAnimate) {
                isAnimate = true
                view.content.startAnimation(scaleAnim(3f, 1f, 3f, 1f,
                        RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f, defaultInit).listener { isAnimate = false })
                isCollapse = true
            }
        }
    }
}