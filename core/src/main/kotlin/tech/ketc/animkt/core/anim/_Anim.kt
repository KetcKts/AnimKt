package tech.ketc.animkt.core.anim

import android.view.animation.*

/**
 * AlphaAnimationを生成します.
 *
 * @param fromAlpha アニメーション開始時の透明度
 * @param toAlpha アニメーション終了時の透明度
 * @param init アニメーションのイニシャライザ
 */
fun alphaAnim(fromAlpha: Float, toAlpha: Float, init: AlphaAnimation.() -> Unit = {}): AlphaAnimation {
    val anim = AlphaAnimation(fromAlpha, toAlpha)
    anim.init()
    return anim
}

/**
 * ScaleAnimationを生成します.
 *
 * @param fromX アニメーション開始時の横方向の大きさ
 * @param toX アニメーション終了時の横方向の大きさ
 * @param fromY アニメーション開始時の縦方向の大きさ
 * @param toY アニメーション終了時の縦方向の大きさ
 * @param init アニメーションのイニシャライザ
 */
fun scaleAnim(fromX: Float, toX: Float, fromY: Float, toY: Float, init: ScaleAnimation.() -> Unit = {}): ScaleAnimation {
    val anim = ScaleAnimation(fromX, toX, fromY, toY)
    anim.init()
    return anim
}

/**
 * ScaleAnimationを生成します.
 *
 * @param fromX アニメーション開始時の横方向の大きさ
 * @param toX アニメーション終了時の横方向の大きさ
 * @param fromY アニメーション開始時の縦方向の大きさ
 * @param toY アニメーション終了時の縦方向の大きさ
 * @param pivotX 横方向のアニメーションの中心点
 * @param pivotY 縦方向のアニメーションの中心点
 * @param init アニメーションのイニシャライザ
 */
fun scaleAnim(fromX: Float, toX: Float, fromY: Float, toY: Float, pivotX: Float, pivotY: Float, init: ScaleAnimation.() -> Unit = {}): ScaleAnimation {
    val anim = ScaleAnimation(fromX, toX, fromY, toY, pivotX, pivotY)
    anim.init()
    return anim
}

/**
 * ScaleAnimationを生成します.
 *
 * @param fromX アニメーション開始時の横方向の大きさ
 * @param toX アニメーション終了時の横方向の大きさ
 * @param fromY アニメーション開始時の縦方向の大きさ
 * @param toY アニメーション終了時の縦方向の大きさ
 * @param pivotXType pivotXのタイプ
 * @param pivotX 横方向のアニメーションの中心点
 * @param pivotYType pivotYのタイプ
 * @param pivotY 縦方向のアニメーションの中心点
 * @param init アニメーションのイニシャライザ
 */
fun scaleAnim(fromX: Float, toX: Float, fromY: Float, toY: Float,
              pivotXType: Int, pivotX: Float, pivotYType: Int, pivotY: Float, init: ScaleAnimation.() -> Unit = {}): ScaleAnimation {
    val anim = ScaleAnimation(fromX, toX, fromY, toY, pivotXType, pivotX, pivotYType, pivotY)
    anim.init()
    return anim
}

/**
 * RotateAnimationを生成します.
 *
 * @param fromDegrees アニメーション開始時の角度
 * @param toDegrees アニメーション終了時の角度
 * @param init アニメーションのイニシャライザ
 */
fun rotateAnim(fromDegrees: Float, toDegrees: Float, init: RotateAnimation.() -> Unit = {}): RotateAnimation {
    val anim = RotateAnimation(fromDegrees, toDegrees)
    anim.init()
    return anim
}

/**
 * RotateAnimationを生成します.
 *
 * @param fromDegrees アニメーション開始時の角度
 * @param toDegrees アニメーション終了時の角度
 * @param pivotX アニメーションの横方向の中心点
 * @param pivotY アニメーションの縦方向の中心点
 * @param init アニメーションのイニシャライザ
 */
fun rotateAnim(fromDegrees: Float, toDegrees: Float, pivotX: Float, pivotY: Float, init: RotateAnimation.() -> Unit = {}): RotateAnimation {
    val anim = RotateAnimation(fromDegrees, toDegrees, pivotX, pivotY)
    anim.init()
    return anim
}

/**
 * RotateAnimationを生成します.
 *
 * @param fromDegrees アニメーション開始時の角度
 * @param toDegrees アニメーション終了時の角度
 * @param pivotXType pivotXのタイプ
 * @param pivotX アニメーションの横方向の中心点
 * @param pivotYType pivotYのタイプ
 * @param pivotY アニメーションの縦方向の中心点
 * @param init アニメーションのイニシャライザ
 */
fun rotateAnim(fromDegrees: Float, toDegrees: Float, pivotXType: Int, pivotX: Float,
               pivotYType: Int, pivotY: Float, init: RotateAnimation.() -> Unit = {}): RotateAnimation {
    val anim = RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotX, pivotYType, pivotY)
    anim.init()
    return anim
}

/**
 * TranslateAnimationを生成します.
 *
 * @param fromXDelta アニメーション開始時の横方向の位置
 * @param toXDelta アニメーション終了時の横方向の位置
 * @param fromYDelta アニメーション開始時の縦方向の位置
 * @param toYDelta アニメーション終了時の縦方向の位置
 * @param init アニメーションのイニシャライザ
 */
fun translateAnim(fromXDelta: Float, toXDelta: Float, fromYDelta: Float, toYDelta: Float, init: TranslateAnimation.() -> Unit = {}): TranslateAnimation {
    val anim = TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta)
    anim.init()
    return anim
}

/**
 * TranslateAnimationを生成します.
 *
 * @param fromXType fromXDeltaのタイプ
 * @param fromXDelta アニメーション開始時の横方向の位置
 * @param toXType toXDeltaのタイプ
 * @param toXDelta アニメーション終了時の横方向の位置
 * @param fromYType fromYDeltaのタイプ
 * @param fromYDelta アニメーション開始時の縦方向の位置
 * @param toYType toYDeltaのタイプ
 * @param toYDelta アニメーション終了時の縦方向の位置
 * @param init アニメーションのイニシャライザ
 */
fun translateAnim(fromXType: Int, fromXDelta: Float, toXType: Int, toXDelta: Float,
                  fromYType: Int, fromYDelta: Float, toYType: Int, toYDelta: Float, init: TranslateAnimation.() -> Unit = {}): TranslateAnimation {
    val anim = TranslateAnimation(fromXType, fromXDelta, toXType, toXDelta, fromYType, fromYDelta, toYType, toYDelta)
    anim.init()
    return anim
}

/**
 * AnimationSetを生成します.
 *
 * @param shareInterpolator shareInterpolator
 * @param init AnimationSetのイニシャライザ
 */
fun animSet(shareInterpolator: Boolean, init: AnimationSet.() -> Unit = {}): AnimationSet {
    val set = AnimationSet(shareInterpolator)
    set.init()
    return set
}