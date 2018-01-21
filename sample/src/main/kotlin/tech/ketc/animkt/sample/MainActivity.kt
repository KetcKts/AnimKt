package tech.ketc.animkt.sample

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBarDrawerToggle
import android.view.KeyEvent
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import tech.ketc.animkt.core.anim.alphaAnim

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val toggle by lazy { ActionBarDrawerToggle(this, drawer, 0, 0) }
    private var current = R.id.alpha

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun commit(fragment: Fragment, @StringRes titleRes: Int, @IdRes menuId: Int) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.frame_fragment, fragment)
                .commit()
        toolbar.subtitle = getString(titleRes)
        current = menuId
        frame_fragment.startAnimation(alphaAnim(0f, 1f) {
            duration = 300
        })
    }

    private fun init() {
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        drawer.addDrawerListener(toggle)
        toggle.isDrawerIndicatorEnabled = true
        navigation.setNavigationItemSelectedListener(this)
        commit(AlphaAnimationFragment(), R.string.alpha_animation, R.id.alpha)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    private fun closeDrawer(): Boolean {
        return if (drawer.isDrawerOpen(navigation)) {
            drawer.closeDrawer(navigation)
            true
        } else {
            false
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId.takeIf { it != current } ?: return false
        when (id) {
            R.id.alpha -> commit(AlphaAnimationFragment(), R.string.alpha_animation, R.id.alpha)
            R.id.alpha_animator -> commit(VPAAlphaAnimationFragment(), R.string.alpha_animation2, R.id.alpha_animator)
            R.id.scale -> commit(ScaleAnimationFragment(), R.string.scale_animation, R.id.scale)
            R.id.scale_animator -> commit(VPAScaleAnimationFragment(), R.string.scale_animation2, R.id.scale_animator)
            R.id.rotate -> commit(RotateAnimationFragment(), R.string.rotate, R.id.rotate)
            R.id.rotate_animator -> commit(VPARotateAnimationFragment(), R.string.rotate_animator, R.id.rotate_animator)
            R.id.trans -> commit(TranslateAnimationFragment(), R.string.trans, R.id.trans)
            R.id.trans_animator -> commit(VPATranslateAnimationFragment(), R.string.trans_animator, R.id.trans_animator)
            R.id.fab_trans -> commit(FABTransFragment(), R.string.fab_trans, R.id.fab_trans)

            else -> return false
        }
        closeDrawer()
        return true
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                if (!closeDrawer()) {
                    moveTaskToBack(true)
                }
            }
            else -> return super.onKeyDown(keyCode, event)
        }
        return true
    }
}
