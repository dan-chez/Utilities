package com.danchez.utilities

import android.app.Activity
import android.content.Context
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.google.android.material.textfield.TextInputLayout
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Validate TextInputLayout input if it is empty, set the error value and return a boolean value
 */
fun TextInputLayout.validateInput(errorText: String): Boolean {
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
fun Activity.hideSoftInput() {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

/**
 * Actual date to string format. Default value = [DD_MM_YYYY_slash]
 */
fun Date.toSimpleString(format: String = DD_MM_YYYY_slash): String {
    return SimpleDateFormat(format, Locale("es", "ES")).format(this)
}

/**
 * Return a [SimpleDateFormat] with first month day set
 */
fun Date.getDateWithFirstMonthDay(): String {
    return SimpleDateFormat("yyyy-MM-", Locale.getDefault()).format(this) + "01"
}

/**
 * Long to format date
 */
fun Long.toTime(time: Long, format: String = DD_MM_YYYY_dash): String {
    val date = Date(time)
    return SimpleDateFormat(format, Locale.getDefault()).format(date)
}

/**
 * Inflate fragments view
 */
fun ViewGroup.inflateView(layoutId: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

/**
 * Get date with the given values
 */
fun Date.getDateWithValues(year: Int, month: Int, date: Int, hour: Int = 0, minute: Int = 0): Date {
    val c = Calendar.getInstance()
    c.set(year, month, date, hour, minute)
    return c.time
}

/**
 * Transform a String to currency format
 */
fun String.toCurrencyFormat(): String {
    val formatter = DecimalFormat("###,###,##0")
    return formatter.format(this.toDouble())
}

/**
 * Get spanned text from a String
 */
fun String.getSpannedText(): Spanned {
    return Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
}
