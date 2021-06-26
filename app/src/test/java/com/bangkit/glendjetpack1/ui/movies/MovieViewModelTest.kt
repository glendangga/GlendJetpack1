package com.bangkit.glendjetpack1.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.utils.DataDummy
import com.bangkit.glendjetpack1.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest  {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<FilmEntity>>>

    @Mock
    private lateinit var filmPagedList: PagedList <FilmEntity>

    @Before
    fun setUp(){
        viewModel = MovieViewModel(contentRepository)
    }


    @Test
    fun getMovies() {
        val dummyFilms = Resource.success(filmPagedList)
        Mockito.`when`(dummyFilms.data?.size).thenReturn(10)
        val films = MutableLiveData<Resource<PagedList<FilmEntity>>>()
        films.value = dummyFilms

        Mockito.`when`(contentRepository.getPopularFilms()).thenReturn(films)

        val courseEntities = viewModel.getMovies().value?.data
        verify(contentRepository).getPopularFilms()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyFilms)
    }
}