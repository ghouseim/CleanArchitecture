package com.example.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesActivity : AppCompatActivity() {

    lateinit var moviesAdapter: MoviesAdapter

    val moviesViewModel: MoviesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        setupRecyclerview()
        observeData()
        getMovies()
    }

    private fun setupRecyclerview() {
        movieList.apply {
            moviesAdapter = MoviesAdapter()
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            adapter = moviesAdapter
        }
    }

    private fun observeData() {
        moviesViewModel.apply {
            movies.observe(this@MoviesActivity, Observer {
                Log.e("Movies", "Observe")
                moviesAdapter.collection = it
            })
        }
    }

    private fun getMovies() {
        moviesViewModel.loadMovies()
    }

}
