package com.danchez.utilities

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class CommonsTest {

    @Test
    fun validateGetMonthsBetweenDates() {
        val initialDate = getDateWithValues(2021, 0, 1)
        val finalDate = getDateWithValues(2022, 0, 1)
        val calendar = Calendar.getInstance()
        calendar.time = initialDate
        val dates = getMonthsBetweenDates(calendar, finalDate)
        Assert.assertEquals(12, dates.size)
    }

    @Test
    fun validateGetDateWithValues() {
        val year = 2022
        val month = 0
        val date = 1
        val hour = 0
        val minute = 0
        val c = Calendar.getInstance()
        c.set(year, month, date, hour, minute)
        Assert.assertEquals(c.time, getDateWithValues(year, month, date))
    }
}
