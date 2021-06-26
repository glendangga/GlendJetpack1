package com.bangkit.glendjetpack1.ui.shows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.glendjetpack1.R
import com.bangkit.glendjetpack1.databinding.FragmentShowBinding
import com.bangkit.glendjetpack1.viewmodel.ViewModelFactory
import com.bangkit.glendjetpack1.vo.Status
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class ShowFragment : DaggerFragment() {

    private lateinit var fragmentShowBinding: FragmentShowBinding
    private val binding get() = fragmentShowBinding

    @Inject
    lateinit var factory: ViewModelFactory


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentShowBinding = FragmentShowBinding.inflate(layoutInflater, container, false)
        return  fragmentShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {


            val showAdapter = ShowAdapter()



            with(fragmentShowBinding.rvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = showAdapter
            }

            observeListShows()
        }
    }

    private fun observeListShows() {


        val viewModel = ViewModelProvider(this, factory)[ShowViewModel::class.java]
        val showAdapter = ShowAdapter()

        viewModel.getShows().observe(viewLifecycleOwner, { show ->
            if (show != null) {
                when (show.status) {
                    Status.LOADING -> binding?.progressBar?.visibility = View.VISIBLE
                    Status.SUCCESS -> {
                        binding?.progressBar?.visibility = View.GONE
                        binding.rvShow.adapter.let { adapter ->
                            when (adapter) {
                                is ShowAdapter -> {
                                    adapter.submitList(show.data)
                                    adapter.notifyDataSetChanged()
                                }
                            }
                        }
                    }
                    Status.ERROR -> {
                        binding?.progressBar?.visibility = View.GONE
                        Toast.makeText(context, "Terjadi kesalahan, silahkan cek kembali !", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }


}