package com.danchez.utilities.model

import com.danchez.utilities.Default
import com.danchez.utilities.ViewTypes
import com.danchez.utilities.interfaces.ViewType
import java.io.Serializable

abstract class BaseDTO(private var viewType: ViewTypes = Default.NONE): ViewType, Serializable {
    override fun getViewType() = viewType
    override fun setViewType(viewType: ViewTypes) {
        this.viewType = viewType
    }
}