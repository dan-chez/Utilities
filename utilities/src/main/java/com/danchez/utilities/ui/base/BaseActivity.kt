package com.danchez.utilities.ui.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.danchez.utilities.R

abstract class BaseActivity: AppCompatActivity() {

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    protected fun displaySimpleToastMessage(message: String = "", duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }
}
