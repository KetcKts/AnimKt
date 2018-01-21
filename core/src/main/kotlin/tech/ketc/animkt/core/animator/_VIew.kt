package tech.ketc.animkt.core.animator

import android.view.View
import android.view.ViewPropertyAnimator

/**
 * Viewを元にViewPropertyAnimatorを生成します.
 */
fun View.animate(init: ViewPropertyAnimator.() -> Unit): ViewPropertyAnimator = animate().apply(init)
