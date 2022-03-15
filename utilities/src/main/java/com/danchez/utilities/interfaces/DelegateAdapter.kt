package com.danchez.utilities.interfaces

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

interface DelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType, position: Int)

}
