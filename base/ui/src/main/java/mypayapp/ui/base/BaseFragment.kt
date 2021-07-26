package mypayapp.ui.base

import android.widget.Toast
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {
    // base fragment related code goes here
    fun showToast(msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }
}