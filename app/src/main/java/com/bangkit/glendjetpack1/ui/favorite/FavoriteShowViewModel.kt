package com.bangkit.glendjetpack1.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import javax.inject.Inject

class FavoriteShowViewModel @Inject constructor(private val contentRepository: ContentRepository) : ViewModel() {

    fun getListFavoriteShow(): LiveData<PagedList<ShowEntity>> = contentRepository.getListFavoriteShows()
}