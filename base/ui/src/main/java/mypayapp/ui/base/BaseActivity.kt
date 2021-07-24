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
        val fragmentTransaction = supportFragmentManager
            .beginTransaction()
            .replace(frameId, fragment)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(tag)
        }
        fragmentTransaction.commit()
    }

    fun open(screenName: String, finishCurrentScreen: Boolean = false) {
        startActivity(NavigateUtils.navigateTo(applicationContext, screenName))
        if (finishCurrentScreen) {
            finish()
        }
    }
}