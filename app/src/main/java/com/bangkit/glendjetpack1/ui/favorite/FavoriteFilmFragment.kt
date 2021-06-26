package com.bangkit.glendjetpack1.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.databinding.FragmentFavoriteFilmBinding
import com.bangkit.glendjetpack1.ui.movies.MovieAdapter
import com.bangkit.glendjetpack1.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteFilmFragment : DaggerFragment(), View.OnClickListener {
    private lateinit var favoriteFilmBinding: FragmentFavoriteFilmBinding
    private val binding get() = favoriteFilmBinding

    @Inject
    lateinit var factory: ViewModelFactory


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        favoriteFilmBinding = FragmentFavoriteFilmBinding.inflate(layoutInflater, container, false)
        return favoriteFilmBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {



            val movieAdapter = MovieAdapter()

            with(favoriteFilmBinding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }

            observeListFavoriteMovies()
        }
    }

    private fun observeListFavoriteMovies() {

        val viewModel = ViewModelProvider(this, factory)[FavoriteFilmViewModel::class.java]
        val movieAdapter = MovieAdapter()

        viewModel.getListFavoriteFilm().observe(viewLifecycleOwner, {
            if (it != null) {
                binding.rvMovie.adapter?.let { adapter ->
                    when (adapter) {
                        is MovieAdapter -> {
                            if (it.isNullOrEmpty()){
                                binding.rvMovie.visibility = View.GONE
                            } else {
                                binding.rvMovie.visibility = View.VISIBLE
                                adapter.submitList(it)
                                adapter.notifyDataSetChanged()
                            }
                        }
                    }
                }

            }
        })
    }

    override fun onClick(v: View?) {

    }

}