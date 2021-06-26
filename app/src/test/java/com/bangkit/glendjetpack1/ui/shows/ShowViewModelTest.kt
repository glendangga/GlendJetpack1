package com.bangkit.glendjetpack1.ui.shows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.ShowEntity
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
class ShowViewModelTest  {

    private lateinit var viewModel: ShowViewModel


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<ShowEntity>>>

    @Mock
    private lateinit var showPagedList: PagedList<ShowEntity>

    @Before
    fun setUp(){
        viewModel = ShowViewModel(contentRepository)
    }

    @Test
    fun getShows(){
        val dummyShows = Resource.success(showPagedList)
        Mockito.`when`(dummyShows.data?.size).thenReturn(10)
        val shows = MutableLiveData<Resource<PagedList<ShowEntity>>>()
        shows.value = dummyShows

        Mockito.`when`(contentRepository.getPopularShow()).thenReturn(shows)

        val courseEntities = viewModel.getShows().value?.data
        verify(contentRepository).getPopularShow()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities?.size)

        viewModel.getShows().observeForever(observer)
        verify(observer).onChanged(dummyShows)

    }
}