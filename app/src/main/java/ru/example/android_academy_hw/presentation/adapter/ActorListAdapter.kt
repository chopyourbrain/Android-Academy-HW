package ru.example.android_academy_hw.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.example.android_academy_hw.databinding.ActorListItemBinding
import ru.example.android_academy_hw.model.ActorData
import ru.example.android_academy_hw.presentation.adapter.base.BaseAdapter
import ru.example.android_academy_hw.presentation.adapter.base.BaseDiffUtilCb
import ru.example.android_academy_hw.presentation.adapter.base.BaseViewHolder

class ActorListAdapter :
    BaseAdapter<ActorData, ActorListAdapter.ActorDiffUtilCb, ActorListAdapter.ActorViewHolder>() {

    override val diffUtilCb = ActorDiffUtilCb()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ActorViewHolder(
        ActorListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class ActorViewHolder(private val binding: ActorListItemBinding) :
        BaseViewHolder<ActorData>(binding.root) {

        override fun bind(item: ActorData, listener: View.OnClickListener?) {

            binding.apply {
                image.setImageResource(item.imageRes)
                name.setText(item.name)
            }

        }
    }

    inner class ActorDiffUtilCb : BaseDiffUtilCb<ActorData>() {
        override fun areItemsTheSame(old: ActorData, new: ActorData): Boolean {
            return old.name == new.name
        }

        override fun areContentsTheSame(old: ActorData, new: ActorData): Boolean {
            return old == new
        }
    }
}
