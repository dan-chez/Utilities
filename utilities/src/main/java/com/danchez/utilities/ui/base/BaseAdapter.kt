package com.danchez.utilities.ui.base

import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.danchez.utilities.model.BaseDTO
import com.danchez.utilities.interfaces.DelegateAdapter

abstract class BaseAdapter<T : BaseDTO> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    lateinit var dataList: ArrayList<T>

    var delegateAdapters = SparseArrayCompat<DelegateAdapter>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))?.onBindViewHolder(holder, dataList[position], position)
    }

    override fun getItemViewType(position: Int): Int = dataList[position].getViewType().type

    override fun getItemCount() = dataList.size

    fun addData(data: List<T>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }
}
