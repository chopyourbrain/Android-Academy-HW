package ru.example.android_academy_hw.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import ru.example.android_academy_hw.databinding.ActorListItemBinding
import ru.example.android_academy_hw.model.Actor
import ru.example.android_academy_hw.presentation.adapter.base.BaseAdapter
import ru.example.android_academy_hw.presentation.adapter.base.BaseDiffUtilCb
import ru.example.android_academy_hw.presentation.adapter.base.BaseViewHolder
import ru.example.android_academy_hw.presentation.adapter.base.ClickElementListener

class ActorListAdapter :
    BaseAdapter<Actor, ActorListAdapter.ActorDiffUtilCb, ActorListAdapter.ActorViewHolder>() {

    override val diffUtilCb = ActorDiffUtilCb()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ActorViewHolder(
        ActorListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class ActorViewHolder(private val binding: ActorListItemBinding) :
        BaseViewHolder<Actor>(binding.root) {

        override fun bind(item: Actor, listener: ClickElementListener<Actor>?) {

            binding.apply {
                Glide.with(itemView)
                    .load(item.picture)
                    .centerCrop()
                    .into(image)
                name.text = item.name
            }

        }
    }

    inner class ActorDiffUtilCb : BaseDiffUtilCb<Actor>() {
        override fun areItemsTheSame(old: Actor, new: Actor): Boolean {
            return old.name == new.name
        }

        override fun areContentsTheSame(old: Actor, new: Actor): Boolean {
            return old.id == new.id
        }
    }
}
