package com.danchez.utilities

import com.danchez.utilities.extensions.*
import com.google.android.material.textfield.TextInputLayout
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
        assertEquals(true, myTextInputLayout.validateInput("My error"))
    }

    @Test
    fun validateDateToSimpleStringWithDefaultFormat() {
        val mysDate = myDate.toSimpleString()
        assertEquals(SimpleDateFormat(DD_MM_YYYY_slash, Locale("es", "ES")).format(myDate), mysDate)
    }

    @Test
    fun validateDateToSimpleStringWithYYYY_MM_DD_slashFormat() {
        val mysDate = myDate.toSimpleString(YYYY_MM_DD_slash)
        assertEquals(SimpleDateFormat(YYYY_MM_DD_slash, Locale("es", "ES")).format(myDate), mysDate)
    }

    @Test
    fun validateGetDateWithFirstMonthDay() {
        val mysDate = myDate.getDateWithFirstMonthDay()
        assertEquals(SimpleDateFormat("yyyy-MM-", Locale.getDefault()).format(myDate) + "01", mysDate)
    }

    @Test
    fun validateLongToStringTimeDefaultFormat() {
        val longTime = myDate.time
        assertEquals(SimpleDateFormat(DD_MM_YYYY_dash, Locale.getDefault()).format(myDate), longTime.toStringTime())
    }

    /*@Test FIXME This is failing in CI
    fun validateStringToCurrencyFormat() {
        val myString = "1234567".toCurrencyFormat()
        Assert.assertEquals("1.234.567", myString)
    }*/

    @Test
    fun validateUpperCaseEachWord() {
        val textToValidate = "this tEXt WiLL Be Modified"
        val textModified = textToValidate.upperCaseEachWord()
        assertEquals("This Text Will Be Modified", textModified)
    }

    @Test
    fun validateUpperCaseFirstLetter() {
        val textToValidate = "this tEXt WiLL Be Modified"
        val textModified = textToValidate.upperCaseFirstLetter()
        assertEquals("This text will be modified", textModified)
    }
}
