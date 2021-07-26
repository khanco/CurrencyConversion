package mypayapp.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import mypayapp.ui.utils.NavigateUtils

open class BaseActivity : AppCompatActivity() {
    fun replaceFragment(
        frameId: Int,
        fragment: Fragment,
        tag: String,
        addToBackStack: Boolean = true
    ) {
        supportFragmentManager
            .beginTransaction()
            .replace(frameId, fragment).apply {
                if (addToBackStack) {
                    this.addToBackStack(tag)
                }
                commit()
            }
    }

    /**
     * this function can navigate to other screen amongst various modules with intent action data.
     */
    fun openScreen(screenName: String, finishCurrentScreen: Boolean = false) {
        startActivity(NavigateUtils.navigateTo(applicationContext, screenName))
        if (finishCurrentScreen) {
            finish()
        }
    }
}