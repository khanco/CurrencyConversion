package mypayapp.dashboard.ui.views

import android.os.Bundle
import mypayapp.dashboard.ui.R
import mypayapp.ui.base.BaseActivity

class DashboardActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        replaceFragment(
            R.id.frameContainer,
            DashboardFragment.getInstance(),
            DashboardFragment::class.simpleName.toString(),
            addToBackStack = false
        )
    }
}