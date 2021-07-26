package mypayapp.ui.utils

import android.content.Context
import android.content.Intent
import android.os.Bundle

// Screen names with their action intent identifier. This will avoid any dependency of other modules
// activity name
const val SCREEN_DASHBOARD = ".module.dashboard"

object NavigateUtils {

    fun navigateTo(context: Context, action: String, bundle: Bundle? = null) =
        internalIntent(context, action, bundle)

    private fun internalIntent(context: Context, action: String, bundle: Bundle? = null) =
        Intent(context.packageName.plus(action)).setPackage(context.packageName).apply {
            if (bundle != null) {
                this.putExtras(bundle)
            }
        }
}