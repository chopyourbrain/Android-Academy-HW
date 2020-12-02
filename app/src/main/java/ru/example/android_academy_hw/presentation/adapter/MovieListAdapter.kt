package ru.example.android_academy_hw.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.example.android_academy_hw.databinding.MovieListItemBinding
import ru.example.android_academy_hw.model.MovieData
import ru.example.android_academy_hw.presentation.adapter.base.BaseAdapter
import ru.example.android_academy_hw.presentation.adapter.base.BaseDiffUtilCb
import ru.example.android_academy_hw.presentation.adapter.base.BaseViewHolder

class MovieListAdapter :
    BaseAdapter<MovieData, MovieListAdapter.MovieDiffUtilCb, MovieListAdapter.MoviesViewHolder>() {

    override val diffUtilCb = MovieDiffUtilCb()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoviesViewHolder(
        MovieListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class MoviesViewHolder(private val binding: MovieListItemBinding) :
        BaseViewHolder<MovieData>(binding.root) {

        override fun bind(item: MovieData, listener: View.OnClickListener?) {

            binding.apply {
                moviePoster.setImageResource(item.imageRes)
                age.text = item.age.toString() + "+"
                movieGenre.text = item.genre
                filmTitle.text = item.title
                runningTime.text = item.runningTime
                reviewsCount.text = item.reviewCount.toString() + " REVIEWS"
                movieCard.setOnClickListener {
                    listener?.onClick(itemView)
                }
            }

        }
    }

    inner class MovieDiffUtilCb : BaseDiffUtilCb<MovieData>() {
        override fun areItemsTheSame(old: MovieData, new: MovieData): Boolean {
            return old.title == new.title
        }

        override fun areContentsTheSame(old: MovieData, new: MovieData): Boolean {
            return old == new
        }
    }
}
