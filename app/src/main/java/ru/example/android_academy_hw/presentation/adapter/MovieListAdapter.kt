package ru.example.android_academy_hw.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import ru.example.android_academy_hw.databinding.MovieListItemBinding
import ru.example.android_academy_hw.model.Movie
import ru.example.android_academy_hw.presentation.adapter.base.BaseAdapter
import ru.example.android_academy_hw.presentation.adapter.base.BaseDiffUtilCb
import ru.example.android_academy_hw.presentation.adapter.base.BaseViewHolder
import ru.example.android_academy_hw.presentation.adapter.base.ClickElementListener

class MovieListAdapter(private val listener: ClickElementListener<Movie>?) :
    BaseAdapter<Movie, MovieListAdapter.MovieDiffUtilCb, MovieListAdapter.MoviesViewHolder>() {

    override val diffUtilCb = MovieDiffUtilCb()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoviesViewHolder(
        MovieListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    inner class MoviesViewHolder(private val binding: MovieListItemBinding) :
        BaseViewHolder<Movie>(binding.root) {

        override fun bind(item: Movie) {

            binding.apply {
                Glide.with(itemView)
                    .load(item.poster)
                    .centerCrop()
                    .into(moviePoster)

                adult.visibility = if (item.adult) View.VISIBLE else View.GONE
                movieGenre.text = item.genres.joinToString(", ") { it.name }
                filmTitle.text = item.title
                runningTime.text = item.runtime.toString() + " min"
                ratingBar.rating = item.ratings / 2
//                reviewsCount.text = item.reviewCount.toString() + " REVIEWS"
                movieCard.setOnClickListener {
                    listener?.onClick(item)
                }
            }

        }
    }

    inner class MovieDiffUtilCb : BaseDiffUtilCb<Movie>() {
        override fun areItemsTheSame(old: Movie, new: Movie): Boolean {
            return old.title == new.title
        }

        override fun areContentsTheSame(old: Movie, new: Movie): Boolean {
            return old == new
        }
    }
}
