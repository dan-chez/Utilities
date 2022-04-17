package com.danchez.utilitiesExample

import android.content.Context
import android.text.Html
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.danchez.utilities.getSpannedText
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExtensionsITest {

    private lateinit var myContext: Context

    @Before
    fun setup() {
        myContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun validateGetSpannedText() {
        val myString = "<![CDATA[Example text:<br><b> \$</b>]]>"
        Assert.assertEquals(Html.fromHtml(myString, Html.FROM_HTML_MODE_COMPACT), myString.getSpannedText())
    }
}
