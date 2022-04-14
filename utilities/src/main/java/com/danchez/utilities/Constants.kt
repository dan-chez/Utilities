package com.danchez.utilities


const val DD_MM_YYYY_slash = "dd/MM/yyyy"
const val DD_MM_YYYY_dash = "dd-MM-yyyy"
const val YYYY_MM_DD_slash = "yyyy/MM/dd"
const val YYYY_MM_DD_dash = "yyyy-MM-dd"

/**
 * Interface to set viewType of the class
 */
interface ViewTypes {
    fun type(): Int
}

/**
 * Default enum class to [ViewTypes]
 */
enum class Default(private val type: Int): ViewTypes {
    NONE(0);
    override fun type(): Int {
        return this.type
    }
}