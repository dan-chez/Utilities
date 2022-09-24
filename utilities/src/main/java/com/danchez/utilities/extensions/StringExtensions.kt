package com.danchez.utilities.extensions

import android.content.Context
import android.text.Html
import android.text.Spanned
import androidx.core.content.pm.PackageInfoCompat
import com.danchez.utilities.DD_MM_YYYY_dash
import com.danchez.utilities.DD_MM_YYYY_slash
import com.danchez.utilities.decimalFormatSymbols
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

val String.Companion.EMPTY: String get() = ""
val String.Companion.SPACE: String get() = " "

/**
 * Transform a String to currency format
 */
fun String.toCurrencyFormat(): String {
    val formatter = DecimalFormat("###,###.00", decimalFormatSymbols())
    return formatter.format(this.toDouble())
}

/**
 * Get spanned text from a String
 */
fun String.getSpannedText(): Spanned {
    return Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
}

/**
 * Get VersionName from [Context]
 */
fun Context.getVersionName(): String {
    return this.packageManager.getPackageInfo(this.packageName, 0).versionName
}

/**
 * Get VersionCode from [Context]
 */
fun Context.getVersionCode(): String {
    return PackageInfoCompat.getLongVersionCode(this.packageManager.getPackageInfo(this.packageName, 0)).toString()
}

/**
 * Capitalizes the first letter of this [String] and lowercase the rest of this [String]
 */
fun String.upperCaseFirstLetter(): String {
    return this.substring(0, 1).uppercase() + this.substring(1).lowercase()
}

/**
 * Capitalizes each first letter of words from [String] and lowercase the rest of this [String]
 */
fun String.upperCaseEachWord(): String {
    val capBuffer = StringBuffer()
    val capMatcher: Matcher = Pattern.compile("([a-z])([a-z]*)", Pattern.CASE_INSENSITIVE).matcher(this)
    while (capMatcher.find()) {
        capMatcher.appendReplacement(
            capBuffer,
            (capMatcher.group(1)?.uppercase(Locale.getDefault())
                ?: String.EMPTY) + (capMatcher.group(2)?.lowercase(Locale.getDefault())
                ?: String.EMPTY)
        )
    }
    return capMatcher.appendTail(capBuffer).toString()
}

/**
 * Actual date to string format. Default value = [DD_MM_YYYY_slash]
 */
fun Date.toSimpleString(format: String = DD_MM_YYYY_slash): String {
    return SimpleDateFormat(format, Locale.getDefault()).format(this)
}

/**
 * Return a [SimpleDateFormat] with first month day set
 */
fun Date.getDateWithFirstMonthDay(): String {
    return SimpleDateFormat("yyyy-MM-", Locale.getDefault()).format(this) + "01"
}

/**
 * Long to format date in String
 */
fun Long.toStringTime(format: String = DD_MM_YYYY_dash): String {
    val date = Date(this)
    return SimpleDateFormat(format, Locale.getDefault()).format(date)
}
