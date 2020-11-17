package com.example.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.presentation.viewstate.MovieView
import kotlinx.android.synthetic.main.row_movie.view.*
import kotlin.properties.Delegates


class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    internal var collection: List<MovieView> by Delegates.observable(emptyList()) { _, _, _ ->
        Log.e("Movies", "Notify")
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_movie, parent, false)
        )

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
        viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movieView: MovieView) {
            Glide.with(itemView.context.applicationContext)
                .load(movieView.poster)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(itemView.moviePoster)
        }
    }
}
