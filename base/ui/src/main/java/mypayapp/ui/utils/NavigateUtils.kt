package mypayapp.ui.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle

// Navigation Constants
const val OPEN_DASHBOARD = ".module.dashboard"

object NavigateUtils {

    fun navigateTo(context: Context, action: String, bundle: Bundle? = null) =
        internalIntent(context, action, bundle)

    private fun internalIntent(context: Context, action: String, bundle: Bundle? = null): Intent {
        val intent = Intent(context.packageName.plus(action)).setPackage(context.packageName)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        return intent
    }
}