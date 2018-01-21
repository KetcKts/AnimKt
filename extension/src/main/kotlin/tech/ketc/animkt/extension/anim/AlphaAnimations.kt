package tech.ketc.animkt.extension.anim

import android.view.View
import android.view.animation.AlphaAnimation
import tech.ketc.animkt.core.anim.AnimCallback
import tech.ketc.animkt.core.anim.alphaAnim
import tech.ketc.animkt.core.anim.listener

private typealias AlphaInit = AlphaAnimation.() -> Unit

private val defaultDuration = 300L

//Alpha
fun fadeIn(init: AlphaInit = { duration = defaultDuration }) = alphaAnim(0F, 1F, init)

fun View.fadeIn(onStart: AnimCallback = {},
                onRepeat: AnimCallback = {},
                onEnd: AnimCallback = {}) = startAnimation(tech.ketc.animkt.extension.anim.fadeIn().listener(onStart, onRepeat, onEnd))

fun fadeOut(init: AlphaInit = { duration = defaultDuration }) = alphaAnim(1F, 0F, init)

fun View.fadeOut(onStart: AnimCallback = {},
                onRepeat: AnimCallback = {},
                onEnd: AnimCallback = {}) = startAnimation(tech.ketc.animkt.extension.anim.fadeOut().listener(onStart, onRepeat, onEnd))
