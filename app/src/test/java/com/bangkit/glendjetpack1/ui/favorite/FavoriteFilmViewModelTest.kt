package com.bangkit.glendjetpack1.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.ui.movies.MovieViewModel
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
class FavoriteFilmViewModelTest {

    private lateinit var viewModel: FavoriteFilmViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<PagedList<FilmEntity>>

    @Mock
    private lateinit var filmPagedList: PagedList<FilmEntity>

    @Mock
    private lateinit var pL: PagedList<FilmEntity>

    @Before
    fun setUp(){
        viewModel = FavoriteFilmViewModel(contentRepository)
    }


    @Test
    fun getListFavoriteFilm() {
        val dummyFilms = pL
        Mockito.`when`(dummyFilms.size).thenReturn(10)
        val films = MutableLiveData<PagedList<FilmEntity>>()
        films.value = dummyFilms

        Mockito.`when`(contentRepository.getListFavoriteFilms()).thenReturn(films)
        val courseEntities = viewModel.getListFavoriteFilm().value
        verify(contentRepository).getListFavoriteFilms()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities?.size)

        viewModel.getListFavoriteFilm().observeForever(observer)
        verify(observer).onChanged(dummyFilms)
    }
}