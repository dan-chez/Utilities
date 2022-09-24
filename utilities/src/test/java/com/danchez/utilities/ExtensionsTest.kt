package com.danchez.utilities

import android.content.Context
import com.danchez.utilities.extensions.*
import com.google.android.material.textfield.TextInputLayout
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@RunWith(MockitoJUnitRunner::class)
class ExtensionsTest {

    private lateinit var myDate: Date

    @Mock
    private lateinit var myTextInputLayout: TextInputLayout

    @Mock
    private lateinit var context: Context

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        myDate = Date()
    }

    @Test
    fun validateTextInputLayoutValidateInputError() {
        val errorMessage = "El campo no puede estar vacío"
        `when`(myTextInputLayout.context).thenReturn(context)
        `when`(context.getString(R.string.default_error_input_empty)).thenReturn(errorMessage)
        `when`(myTextInputLayout.error).thenReturn(errorMessage)
        assertEquals(true, myTextInputLayout.validateInput())
        assertEquals(errorMessage, myTextInputLayout.error)
    }

    @Test
    fun validateDateToSimpleStringWithDefaultFormat() {
        val mysDate = myDate.toSimpleString()
        assertEquals(SimpleDateFormat(DD_MM_YYYY_slash, Locale.getDefault()).format(myDate), mysDate)
    }

    @Test
    fun validateDateToSimpleStringWithYYYY_MM_DD_slashFormat() {
        val mysDate = myDate.toSimpleString(YYYY_MM_DD_slash)
        assertEquals(SimpleDateFormat(YYYY_MM_DD_slash, Locale.getDefault()).format(myDate), mysDate)
    }

    @Test
    fun validateGetDateWithFirstMonthDay() {
        val mysDate = myDate.getDateWithFirstMonthDay()
        assertEquals(
            SimpleDateFormat("yyyy-MM-", Locale.getDefault()).format(myDate) + "01",
            mysDate
        )
    }

    @Test
    fun validateLongToStringTimeDefaultFormat() {
        val longTime = myDate.time
        assertEquals(
            SimpleDateFormat(DD_MM_YYYY_dash, Locale.getDefault()).format(myDate),
            longTime.toStringTime()
        )
    }

    @Test
    fun validateStringToCurrencyFormat() {
        val myString = "1234567".toCurrencyFormat()
        assertEquals("1,234,567.00", myString)
    }

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
