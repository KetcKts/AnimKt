package tech.ketc.animkt.extension.animator

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.support.design.widget.FloatingActionButton
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.view.View
import android.view.ViewAnimationUtils
import android.view.ViewGroup
import tech.ketc.animkt.core.anim.alphaAnim
import tech.ketc.animkt.core.anim.listener
import tech.ketc.animkt.core.animator.listener
import tech.ketc.animkt.extension.view.util.gone
import tech.ketc.animkt.extension.view.util.invisible
import tech.ketc.animkt.extension.view.util.visible

class FabRevealTransform(private val fab: FloatingActionButton,
                         private val targetView: View,
                         private val fabColor: Int,
                         private val targetColor: Int) {


    private val defaultDuration: Long = 400
    private var isAnimate = false

    /**
     * start the reveal transform animation.
     * state alternately changes each time you call.
     */
    fun start() {
        //todo 稀にFabに変形する際に閉じる要素が一瞬映る。
        
        if (isAnimate) return
        isAnimate = true
        val fabIsVisible = fab.visibility == View.VISIBLE
        if (fabIsVisible) fab.isClickable = false
        val elevation = fab.elevation
        fab.elevation = -elevation

        //reveal
        val targetWidth = targetView.width
        val targetHeight = targetView.height
        val targetMaxSide = Math.max(targetWidth, targetHeight)
        val fabSide = fab.width
        val startRadius = if (fabIsVisible) fabSide / 2f else targetMaxSide * 2f
        val endRadius = if (fabIsVisible) targetMaxSide * 2f else fabSide / 2f
        val targetCenterX = targetWidth / 2
        val targetCenterY = targetHeight / 2
        val revealAnimator = ViewAnimationUtils.createCircularReveal(targetView,
                targetCenterX, targetCenterY, startRadius, endRadius)
        revealAnimator.duration = defaultDuration
        revealAnimator.interpolator = if (fabIsVisible) FastOutSlowInInterpolator() else LinearOutSlowInInterpolator()

        //colorFade
        val colorAnimation = ValueAnimator.ofObject(ArgbEvaluator(),
                if (fabIsVisible) fabColor else targetColor,
                if (fabIsVisible) targetColor else fabColor)
        colorAnimation.duration = defaultDuration
        colorAnimation.addUpdateListener { animator -> targetView.setBackgroundColor(animator.animatedValue as Int) }

        //alpha
        val fadeContents = ArrayList<View>()
        fun traceViewGroup(viewGroup: ViewGroup) {
            (0..(viewGroup.childCount - 1)).forEach {
                val child = viewGroup.getChildAt(it)
                if (child is ViewGroup) {
                    traceViewGroup(child)
                } else {
                    fadeContents.add(child)
                }
            }
        }
        (targetView as? ViewGroup)?.let { traceViewGroup(it) }
        revealAnimator.listener(
                onStart = {
                    if (fabIsVisible) {
                        targetView.visible()
                        targetView.isFocusable = true
                    } else {
                        targetView.isFocusable = false
                    }
                },
                onEnd = {
                    if (!fabIsVisible) targetView.invisible()
                    isAnimate = false
                })
        val fabTargetAlpha = if (fabIsVisible) 0f else 1f
        val targetViewTargetAlpha = if (fabIsVisible) 1f else 0f


        colorAnimation.start()
        revealAnimator.start()
        fab.startAnimation(alphaAnim(targetViewTargetAlpha, fabTargetAlpha) {
            this.duration = if (fabIsVisible) defaultDuration / 4 else defaultDuration
            fillAfter = true
        }.listener(
                onStart = {
                    if (!fabIsVisible) {
                        fab.isClickable = true
                        fab.visible()
                    }
                },
                onEnd = {
                    if (fabIsVisible) fab.gone()
                }))

        fadeContents.forEach {
            it.startAnimation(alphaAnim(fabTargetAlpha, targetViewTargetAlpha) {
                this.duration = if (fabIsVisible) defaultDuration else defaultDuration / 4
                fillAfter = true
            })
        }
    }
}