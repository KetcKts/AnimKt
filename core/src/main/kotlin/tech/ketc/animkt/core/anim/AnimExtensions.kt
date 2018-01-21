package tech.ketc.animkt.core.anim

import android.view.animation.Animation

typealias AnimCallback = (Animation) -> Unit

/**
 * Animationにアニメーションリスナーをセットする為のユーティリティ.
 *
 * @param onStart この関数は [Animation.AnimationListener.onAnimationStart] で実行されます
 * @param onRepeat この関数は [Animation.AnimationListener.onAnimationRepeat] で実行されます
 * @param onEnd この関数は [Animation.AnimationListener.onAnimationEnd] で実行されます
 * @return レシーバ
 */
fun Animation.listener(onStart: AnimCallback = {},
                       onRepeat: AnimCallback = {},
                       onEnd: AnimCallback = {}): Animation {
    this.setAnimationListener(object : Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {
            onStart(animation)
        }

        override fun onAnimationRepeat(animation: Animation) {
            onRepeat(animation)
        }

        override fun onAnimationEnd(animation: Animation) {
            onEnd(animation)
        }
    })
    return this
}