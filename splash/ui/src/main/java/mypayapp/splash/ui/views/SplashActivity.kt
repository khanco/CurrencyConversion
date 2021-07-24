package mypayapp.splash.ui.views

import android.os.Bundle
import mypayapp.splash.ui.R
import mypayapp.ui.base.BaseActivity
import mypayapp.ui.utils.DASHBOARD_SCREEN

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        open(DASHBOARD_SCREEN)
    }
}