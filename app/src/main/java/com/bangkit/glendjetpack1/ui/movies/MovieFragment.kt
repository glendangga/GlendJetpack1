package com.bangkit.glendjetpack1.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.databinding.FragmentMovieBinding
import com.bangkit.glendjetpack1.viewmodel.ViewModelFactory
import com.bangkit.glendjetpack1.vo.Status
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MovieFragment : DaggerFragment() {
    private lateinit var fragmentMovieBinding: FragmentMovieBinding
    private val binding get() = fragmentMovieBinding

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentMovieBinding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            observeListMovies()

            val movieAdapter = MovieAdapter()
            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = movieAdapter
            }


        }
    }

    private fun observeListMovies() {

        val viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]
        val movieAdapter = MovieAdapter()

        viewModel.getMovies().observe(viewLifecycleOwner, { film ->
            if (film != null) {
                when (film.status) {
                    Status.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding.progressBar.visibility = View.GONE
                        binding.rvMovie.adapter.let { adapter ->
                            when (adapter) {
                                is MovieAdapter -> {
                                    adapter.submitList(film.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan, silahkan cek kembali !", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }


}