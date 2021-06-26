package com.bangkit.glendjetpack1.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailShowViewModelTest {
    private lateinit var viewModel: DetailShowViewModel
    private val dummyCourse = DataDummy.generateDummyShow()[0]
    private val showId = dummyCourse.showId

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<ShowEntity>

    @Before
    fun setUp(){
        viewModel = DetailShowViewModel(contentRepository)
        viewModel.setSelectedCourse(showId)
    }

    @Test
    fun getCourse() {

        val show = MutableLiveData<ShowEntity>()
        show.value = dummyCourse

        Mockito.`when`(contentRepository.getShowDetail(showId)).thenReturn(show)

        viewModel.setSelectedCourse(dummyCourse.showId)

        val courseEntity = viewModel.getCourse(showId).value as ShowEntity
        Assert.assertNotNull(courseEntity)
        assertEquals(dummyCourse.showId, courseEntity.showId)
        assertEquals(dummyCourse.date, courseEntity.date)
        assertEquals(dummyCourse.description, courseEntity.description)
        assertEquals(dummyCourse.title, courseEntity.title)
        assertEquals(dummyCourse.imagePath, courseEntity.imagePath)

        viewModel.getCourse(showId).observeForever(observer)
        verify(observer).onChanged(dummyCourse)
    }



}