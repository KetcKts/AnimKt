package tech.ketc.animkt.extension.animator

import android.content.Context
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.view.View
import android.view.ViewPropertyAnimator
import tech.ketc.animkt.core.animator.*
import tech.ketc.animkt.core.util.adjustDuration


fun ViewPropertyAnimator.defaultInit(context: Context) {
    duration = adjustDuration(275, context)
    interpolator = FastOutSlowInInterpolator()
}

fun ViewPropertyAnimator.defaultInitDelay(context: Context) {
    duration = adjustDuration(350, context)
    startDelay = adjustDuration(25, context)
    interpolator = FastOutSlowInInterpolator()
}

fun View.expandMtrl(toX: Float, toY: Float,
                    onStart: AnimatorCallback = {}, onEnd: AnimatorCallback = {}) {
    val animate1 = animate {
        toXScale = toX
        defaultInit(context)
    }
    val animate2 = animate {
        toYScale = toY
        defaultInitDelay(context)
    }
    animate1.withStartAction { animate2.listener(onStart = onStart, onEnd = onEnd).start() }.start()
}

fun View.collapseMtrl(toX: Float = 1f, toY: Float = 1f,
                      onStart: AnimatorCallback = {}, onEnd: AnimatorCallback = {}) {
    val animate1 = animate {
        toYScale = toY
        defaultInit(context)
    }
    val animate2 = animate {
        toXScale = toX
        defaultInitDelay(context)
    }
    animate1.withStartAction { animate2.listener(onStart = onStart, onEnd = onEnd).start() }.start()
}