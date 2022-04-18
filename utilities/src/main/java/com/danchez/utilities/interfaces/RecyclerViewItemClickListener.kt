package com.danchez.utilities.interfaces

/**
 * Interface to implement click actions to recyclerView with Item info [T]
 */
interface RecyclerViewItemClickListener<T> {

    fun onClickLister(position: Int, data: T?)

    fun onLongClickListener(position: Int, data: T?)
}
