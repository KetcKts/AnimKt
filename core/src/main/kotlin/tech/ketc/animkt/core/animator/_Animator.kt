package tech.ketc.animkt.core.animator

import android.animation.Animator
import android.view.ViewPropertyAnimator

var ViewPropertyAnimator.fromAlpha: Float
    set(value) {
        alphaBy(value)
    }
    get() {
        throw UnsupportedOperationException()
    }

var ViewPropertyAnimator.toAlpha: Float
    set(value) {
        alpha(value)
    }
    get() {
        throw UnsupportedOperationException()
    }


var ViewPropertyAnimator.fromXScale: Float
    set(value) {
        scaleXBy(value)
    }
    get() {
        throw UnsupportedOperationException()
    }

var ViewPropertyAnimator.toXScale: Float
    set(value) {
        scaleX(value)
    }
    get() {
        throw UnsupportedOperationException()
    }

var ViewPropertyAnimator.fromYScale: Float
    set(value) {
        scaleYBy(value)
    }
    get() {
        throw UnsupportedOperationException()
    }

var ViewPropertyAnimator.toYScale: Float
    set(value) {
        scaleY(value)
    }
    get() {
        throw UnsupportedOperationException()
    }


var ViewPropertyAnimator.fromDegrees: Float
    set(value) {
        rotationBy(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }

var ViewPropertyAnimator.toDegrees: Float
    set(value) {
        rotation(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }

var ViewPropertyAnimator.fromDegreesX: Float
    set(value) {
        rotationXBy(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }

var ViewPropertyAnimator.toDegreesX: Float
    set(value) {
        rotationX(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }


var ViewPropertyAnimator.fromDegreesY: Float
    set(value) {
        rotationYBy(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }

var ViewPropertyAnimator.toDegreesY: Float
    set(value) {
        rotationY(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }

var ViewPropertyAnimator.fromXDelta: Float
    set(value) {
        translationX(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }


var ViewPropertyAnimator.toXDelta: Float
    set(value) {
        translationX(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }

var ViewPropertyAnimator.fromYDelta: Float
    set(value) {
        translationYBy(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }

var ViewPropertyAnimator.toYDelta: Float
    set(value) {
        translationY(value)
    }
    get() {
        throw  UnsupportedOperationException()
    }


typealias AnimatorCallback = (Animator) -> Unit


/**
 * ViewPropertyAnimatorにアニメーションリスナーをセットする為のユーティリティ
 *
 * @param onStart この関数は [Animator.AnimatorListener.onAnimationRepeat] で実行されます
 * @param onCancel この関数は [Animator.AnimatorListener.onAnimationCancel] で実行されます
 * @param onRepeat この関数は [Animator.AnimatorListener.onAnimationRepeat] で実行されます
 * @param onEnd この関数は [Animator.AnimatorListener.onAnimationEnd] で実行されます
 * @return レシーバ
 */
fun ViewPropertyAnimator.listener(onStart: AnimatorCallback = {},
                                  onCancel: AnimatorCallback = {},
                                  onRepeat: AnimatorCallback = {},
                                  onEnd: AnimatorCallback = {}): ViewPropertyAnimator {
    this.setListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {
            onStart(animation)
        }

        override fun onAnimationCancel(animation: Animator) {
            onCancel(animation)
        }

        override fun onAnimationRepeat(animation: Animator) {
            onRepeat(animation)
        }

        override fun onAnimationEnd(animation: Animator) {
            onEnd(animation)
        }
    })
    return this
}

/**
 * Animatorにアニメーションリスナーをセットする為のユーティリティ.
 *
 * @param onStart この関数は [Animator.AnimatorListener.onAnimationRepeat] で実行されます
 * @param onCancel この関数は [Animator.AnimatorListener.onAnimationCancel] で実行されます
 * @param onRepeat この関数は [Animator.AnimatorListener.onAnimationRepeat] で実行されます
 * @param onEnd この関数は [Animator.AnimatorListener.onAnimationEnd] で実行されます
 * @return レシーバ
 */
fun Animator.listener(onStart: AnimatorCallback = {},
                      onCancel: AnimatorCallback = {},
                      onRepeat: AnimatorCallback = {},
                      onEnd: AnimatorCallback = {}): Animator {
    this.addListener(object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator) {
            onStart(animation)
        }

        override fun onAnimationCancel(animation: Animator) {
            onCancel(animation)
        }

        override fun onAnimationRepeat(animation: Animator) {
            onRepeat(animation)
        }

        override fun onAnimationEnd(animation: Animator) {
            onEnd(animation)
        }
    })
    return this
}


