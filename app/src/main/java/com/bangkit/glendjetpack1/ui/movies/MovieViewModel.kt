package com.bangkit.glendjetpack1.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.utils.DataDummy
import com.bangkit.glendjetpack1.vo.Resource
import javax.inject.Inject

class MovieViewModel @Inject constructor(private val contentRepository: ContentRepository): ViewModel() {

    fun getMovies(): LiveData<Resource<PagedList<FilmEntity>>> = contentRepository.getPopularFilms()
}