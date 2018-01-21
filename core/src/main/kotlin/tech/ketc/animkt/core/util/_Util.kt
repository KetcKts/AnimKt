package tech.ketc.animkt.core.util

import android.content.Context

fun isTablet(context: Context)
        = context.resources.configuration.smallestScreenWidthDp >= 600

fun isWearable(context: Context)
        = context.resources.configuration.smallestScreenWidthDp <= 250


fun dp(context: Context, point: Float): Float {
    val density = context.resources.displayMetrics.density
    return point * density
}

/**
 * adjust duration by wearable terminal, tablet or not.
 *
 * @return adjusted duration
 */
fun adjustDuration(standardDuration: Long, context: Context) = when {
    isTablet(context) -> (standardDuration * 1.3).toLong()
    isWearable(context) -> (standardDuration * 0.7).toLong()
    else -> standardDuration
}