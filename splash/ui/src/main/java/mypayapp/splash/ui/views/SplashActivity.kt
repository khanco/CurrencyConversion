package mypayapp.splash.ui.views

import android.os.Bundle
import mypayapp.splash.ui.R
import mypayapp.ui.base.BaseActivity
import mypayapp.ui.utils.NavigateUtils
import mypayapp.ui.utils.OPEN_DASHBOARD

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        NavigateUtils.navigateTo(applicationContext, OPEN_DASHBOARD)
    }
}