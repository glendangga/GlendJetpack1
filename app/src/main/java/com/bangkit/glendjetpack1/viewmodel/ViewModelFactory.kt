package com.bangkit.glendjetpack1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.ui.detail.DetailFilmViewModel
import com.bangkit.glendjetpack1.ui.detail.DetailShowViewModel
import com.bangkit.glendjetpack1.ui.favorite.FavoriteFilmViewModel
import com.bangkit.glendjetpack1.ui.favorite.FavoriteShowViewModel
import com.bangkit.glendjetpack1.ui.movies.MovieViewModel
import com.bangkit.glendjetpack1.ui.shows.ShowViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val mContentRepository: ContentRepository): ViewModelProvider.NewInstanceFactory() {


    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(DetailFilmViewModel::class.java) -> {
                DetailFilmViewModel(mContentRepository) as T
            }
            modelClass.isAssignableFrom(DetailShowViewModel::class.java) -> {
                DetailShowViewModel(mContentRepository) as T
            }
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mContentRepository) as T
            }
            modelClass.isAssignableFrom(ShowViewModel::class.java) -> {
                ShowViewModel(mContentRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteFilmViewModel::class.java) -> {
                FavoriteFilmViewModel(mContentRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteShowViewModel::class.java) -> {
                FavoriteShowViewModel(mContentRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}