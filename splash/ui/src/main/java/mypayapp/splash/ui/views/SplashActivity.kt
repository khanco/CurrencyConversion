package mypayapp.splash.ui.views

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import mypayapp.splash.ui.R
import mypayapp.splash.ui.utils.SPLASH_TIMER
import mypayapp.ui.base.BaseActivity
import mypayapp.ui.utils.SCREEN_DASHBOARD

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        goToDashboard()
    }

    private fun goToDashboard() {
        Handler(Looper.getMainLooper()).postDelayed(
            {
                openScreen(SCREEN_DASHBOARD, finishCurrentScreen = true)
            }, SPLASH_TIMER
        )
    }
}