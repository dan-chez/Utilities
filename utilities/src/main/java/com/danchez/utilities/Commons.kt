package com.danchez.utilities

import com.danchez.utilities.extensions.validateInput
import com.google.android.material.textfield.TextInputLayout
import java.text.DecimalFormatSymbols
import java.util.*

val Char.Companion.DOT: Char get() = '.'
val Char.Companion.COMMA: Char get() = ','

/**
 * Returns a [Boolean] value depending of the inputs validations of [inputs]
 * * [error] is a String with the error that is going to set to error value in the layout
 */
fun validateTextInputLayoutList(inputs: List<TextInputLayout>, error: String): Boolean {
    var result = true
    for (input in inputs) {
        if (!input.validateInput(error)) result = false
    }
    return result
}

/**
 * Returns a [List] of months in [Date] format between [initialDate] and [finalDate]
 *  * [initialDate] is current date as default value
 */
fun getMonthsBetweenDates(initialDate: Calendar = Calendar.getInstance(), finalDate: Date = Calendar.getInstance().time): List<Date> {
    val ret: MutableList<Date> = ArrayList()
    while (initialDate.timeInMillis < finalDate.time) {
        initialDate.add(Calendar.MONTH, 1)
        ret.add(initialDate.time)
    }
    return ret.subList(0, ret.size - 1)
}

/**
 * Get date with the given values
 */
fun getDateWithValues(year: Int, month: Int, date: Int, hour: Int = 0, minute: Int = 0): Date {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, date, hour, minute)
    return calendar.time
}

/**
 * Get [DecimalFormatSymbols] for format
 */
fun decimalFormatSymbols(decimalSeparator: Char = Char.DOT, groupingSeparator: Char = Char.COMMA): DecimalFormatSymbols {
    return DecimalFormatSymbols().apply {
        this.decimalSeparator = decimalSeparator
        this.groupingSeparator = groupingSeparator
    }
}
