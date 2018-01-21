package tech.ketc.animkt.core.util.context

import android.content.Context

val Context.isTablet: Boolean
    get() = tech.ketc.animkt.core.util.isTablet(this)

val Context.isWearable: Boolean
    get() = tech.ketc.animkt.core.util.isWearable(this)

fun Context.dp(point: Float) = tech.ketc.animkt.core.util.dp(this, point)


fun Context.adjustDuration(standardDuration: Long)
        = tech.ketc.animkt.core.util.adjustDuration(standardDuration, this)