# AnimKt

---

AnimKtはAndroidでのアニメーション作成用の簡易的なDSLです。

モジュールは以下のとおりです。

* core - 基本的なDSLについての機能を提供します。
* extension - かんたんなアニメーションのテンプレ等を提供します。

---

フェードアウトするアニメーションのDSLの単純な例

```
alphaAnim(1f, 0f) {
    duration = 300
    fillAfter = true
}.listener(onEnd = { hoge() })
```

上記のコードでは期間が300m secでアニメーション終了後にその状態を維持するAlphaAnimationを生成しています。
与えるパラメータ等は通常のAnimationと差はありません。
生成したアニメーションに```listener()```でイベントリスナーをセットできます。
その他標準の Rotate,Scale,Translate のアニメーションについても同様の方法で生成できます。

---

フェードアウトするアニメーションのDSLの単純な例(ViewPropertyAnimator)

```
view.animate {
    duration = 300
    fromAlpha = 1f
    toAlpha = 0f
}
```

上記のコードは
```
view.animate()
    .setDuration(300)
    .alphaBy(1f)
    .alpha(0f)
```
と同義です。

ViewPropertyAnimatorをDSLで扱う場合、使用するプロパティと実際に動くメソッドの名前に差異があります。
対応は以下のとおりです。

* fromAlpha - alphaBy
* toAlpha - alpha
* fromXScale - scaleXBy
* toXScale - scaleX
* fromYScale - scaleYBy
* toYScale - scaleY
* fromDegrees - rotationBy
* toDegrees - rotation
* fromDegreesX - rotationXBy
* toDegreesX - rotationX
* fromDegreesY - rotationYBy
* toDegreesY - rotationY
* fromXDelta - translationX
* toXDelta - translationX
* fromYDelta - translationYBy
* toYDelta - translationY

---

Gradle

```
dependencies {
    implementation 'tech.ketc.animkt:core:1.0.0'
    implementation 'tech.ketc.animkt:extension:1.0.0'
}

repositories {
    maven {
        url 'http://ketckts.github.io/repoanimkt/repository'
    }
}
```

---

[ドキュメント](https://ketckts.github.io/repoanimkt/core/index)