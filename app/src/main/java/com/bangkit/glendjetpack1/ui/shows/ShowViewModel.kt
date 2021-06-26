package com.bangkit.glendjetpack1.ui.shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.utils.DataDummy
import com.bangkit.glendjetpack1.vo.Resource
import javax.inject.Inject

class ShowViewModel @Inject constructor (private val contentRepository: ContentRepository) : ViewModel() {

    fun getShows(): LiveData<Resource<PagedList<ShowEntity>>> = contentRepository.getPopularShow()
}