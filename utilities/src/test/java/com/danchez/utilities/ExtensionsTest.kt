package com.danchez.utilities

import com.google.android.material.textfield.TextInputLayout
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.text.SimpleDateFormat
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class ExtensionsTest {

    private lateinit var myDate: Date

    @Mock
    private lateinit var myTextInputLayout: TextInputLayout

    @Before
    fun setup() {
        myDate = Date()
    }

    @Test
    fun validateTextInputLayoutValidateInputError() {
        Assert.assertEquals(true, myTextInputLayout.validateInput("My error"))
    }

    @Test
    fun validateDateToSimpleStringWithDefaultFormat() {
        val mysDate = myDate.toSimpleString()
        Assert.assertEquals(SimpleDateFormat(DD_MM_YYYY_slash, Locale("es", "ES")).format(myDate), mysDate)
    }

    @Test
    fun validateDateToSimpleStringWithYYYY_MM_DD_slashFormat() {
        val mysDate = myDate.toSimpleString(YYYY_MM_DD_slash)
        Assert.assertEquals(SimpleDateFormat(YYYY_MM_DD_slash, Locale("es", "ES")).format(myDate), mysDate)
    }

    @Test
    fun validateGetDateWithFirstMonthDay() {
        val mysDate = myDate.getDateWithFirstMonthDay()
        Assert.assertEquals(SimpleDateFormat("yyyy-MM-", Locale.getDefault()).format(myDate) + "01", mysDate)
    }

    @Test
    fun validateLongToStringTimeDefaultFormat() {
        val longTime = myDate.time
        Assert.assertEquals(SimpleDateFormat(DD_MM_YYYY_dash, Locale.getDefault()).format(myDate), longTime.toStringTime())
    }

    @Test
    fun validateStringToCurrencyFormat() {
        val myString = "1234567".toCurrencyFormat()
        Assert.assertEquals("1.234.567", myString)
    }
}
