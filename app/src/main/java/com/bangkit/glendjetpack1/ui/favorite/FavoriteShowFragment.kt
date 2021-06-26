package com.bangkit.glendjetpack1.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.databinding.FragmentFavoriteShowBinding
import com.bangkit.glendjetpack1.ui.shows.ShowAdapter
import com.bangkit.glendjetpack1.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class FavoriteShowFragment : DaggerFragment() {

    private lateinit var favoriteShowBinding: FragmentFavoriteShowBinding
    private val binding get() = favoriteShowBinding

    private lateinit var viewModel: FavoriteShowViewModel
    private lateinit var showAdapter: ShowAdapter
    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        favoriteShowBinding = FragmentFavoriteShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            showAdapter = ShowAdapter()

            with(favoriteShowBinding.rvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = showAdapter
            }

            observeListFavoriteShows()
        }
    }

    private fun observeListFavoriteShows() {

        viewModel = ViewModelProvider(this, factory)[FavoriteShowViewModel::class.java]
        showAdapter = ShowAdapter()

        viewModel.getListFavoriteShow().observe(viewLifecycleOwner, {
            if (it != null){
                binding.rvShow.adapter?.let {
                        adapter ->
                    when (adapter){
                        is ShowAdapter -> {
                            if (it.isNullOrEmpty()){
                                binding.rvShow.visibility = View.GONE
                            } else {
                                binding.rvShow.visibility = View.VISIBLE
                                adapter.submitList(it)
                                adapter.notifyDataSetChanged()
                            }
                        }
                    }
                }
            }

        })
    }


}