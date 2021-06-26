package com.bangkit.glendjetpack1.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.utils.DataDummy
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
class DetailFilmViewModelTest {
    private lateinit var viewModel: DetailFilmViewModel
    private val dummyCourse = DataDummy.generateDummyFilm()[0]
    private val filmId = dummyCourse.filmId

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<FilmEntity>


    @Before
    fun setUp(){
        viewModel = DetailFilmViewModel(contentRepository)
        viewModel.setSelectedCourse(filmId)
    }

    @Test
    fun getCourse() {

        val film = MutableLiveData<FilmEntity>()
        film.value = dummyCourse

        Mockito.`when`(contentRepository.getFilmDetail(filmId)).thenReturn(film)

        viewModel.setSelectedCourse(dummyCourse.filmId)

        val courseEntity = viewModel.getCourse(filmId).value as FilmEntity
        Assert.assertNotNull(courseEntity)
        assertEquals(dummyCourse.filmId, courseEntity.filmId)
        assertEquals(dummyCourse.date, courseEntity.date)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.title, courseEntity.title)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)

        viewModel.getCourse(filmId).observeForever(observer)
        verify(observer).onChanged(dummyCourse)
    }


}