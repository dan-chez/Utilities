package com.danchez.utilities.extensions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.danchez.utilities.R
import com.google.android.material.textfield.TextInputLayout

/**
 * Validate TextInputLayout input if it is empty, set the error value and return a boolean value
 */
fun TextInputLayout.validateInput(errorText: String = context.getString(R.string.default_error_input_empty)): Boolean {
    return if (this.editText?.text.toString().isEmpty()) {
        this.error = errorText
        false
    } else {
        this.error = null
        true
    }
}

/**
 * Hide keyboard
 */
fun View.hideSoftInput() {
    val inputMethodManager = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this.windowToken, 0)
}

/**
 * Show keyboard
 */
fun View.showSoftInput() {
    val inputMethodManager = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * Inflate fragments view
 */
fun ViewGroup.inflateView(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}
