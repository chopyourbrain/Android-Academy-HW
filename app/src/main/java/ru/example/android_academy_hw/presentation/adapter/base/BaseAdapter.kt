package ru.example.android_academy_hw.presentation.adapter.base

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

abstract class BaseAdapter<I, DU : BaseDiffUtilCb<I>, VH : BaseViewHolder<I>> :
    RecyclerView.Adapter<VH>(), CoroutineScope {
    override val coroutineContext = Dispatchers.Main

    private val initialItems = ArrayList<I>()
    private val items = ArrayList<I>()

    var listener: View.OnClickListener? = null

    abstract val diffUtilCb: DU

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItemAt(position), listener)
    }

    override fun onViewRecycled(holder: VH) {
        holder.unbind()
    }

    fun getItemAt(position: Int) = items[position]

    fun setItems(newItems: List<I>) {
        update(UpdateListOperation.SetItems(newItems))
    }

    private val eventActor = actor<UpdateListOperation<I>>(Dispatchers.IO, capacity = Channel.BUFFERED) {
        for (it in channel)
            internalUpdate(it)
    }

    private fun update(operation: UpdateListOperation<I>) = eventActor.offer(operation)

    private fun internalUpdate(operation: UpdateListOperation<I>) {
        diffUtilCb.oldItems = ArrayList(items)
        if (operation is UpdateListOperation.SetItems) {
            operation.newItems?.let {
                items.clear()
                items.addAll(it)
            }
            diffUtilCb.newItems = initialItems
            val result = DiffUtil.calculateDiff(diffUtilCb, false)
            launch(Dispatchers.Main) {
                result.dispatchUpdatesTo(this@BaseAdapter)
            }
        }
    }

    internal sealed class UpdateListOperation<I> {
        data class SetItems<I>(val newItems: List<I>?) : UpdateListOperation<I>()
    }

    override fun getItemId(position: Int): Long = position.toLong()

}

abstract class BaseDiffUtilCb<I> : DiffUtil.Callback() {
    lateinit var oldItems: List<I>
    lateinit var newItems: List<I>

    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areContentsTheSame(oldItems[oldItemPosition], newItems[newItemPosition])
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return areItemsTheSame(oldItems[oldItemPosition], newItems[newItemPosition])
    }

    abstract fun areItemsTheSame(old: I, new: I): Boolean

    abstract fun areContentsTheSame(old: I, new: I): Boolean
}

abstract class BaseViewHolder<I>(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: I, listener: View.OnClickListener?)

    fun unbind() {}
}