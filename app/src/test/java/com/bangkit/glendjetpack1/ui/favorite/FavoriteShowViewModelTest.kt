package com.bangkit.glendjetpack1.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
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
class FavoriteShowViewModelTest {

    private lateinit var viewModel: FavoriteShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var contentRepository: ContentRepository

    @Mock
    private lateinit var observer: Observer<PagedList<ShowEntity>>

    @Mock
    private lateinit var showPagedList: PagedList<ShowEntity>

    @Mock
    private lateinit var pL: PagedList<ShowEntity>

    @Before
    fun setUp(){
        viewModel = FavoriteShowViewModel(contentRepository)
    }


    @Test
    fun getListFavoriteShow() {
        val dummyShows = pL
        Mockito.`when`(dummyShows.size).thenReturn(10)
        val shows = MutableLiveData<PagedList<ShowEntity>>()
        shows.value = dummyShows

        Mockito.`when`(contentRepository.getListFavoriteShows()).thenReturn(shows)
        val courseEntities = viewModel.getListFavoriteShow().value
        verify(contentRepository).getListFavoriteShows()
        Assert.assertNotNull(courseEntities)
        Assert.assertEquals(10, courseEntities?.size)

        viewModel.getListFavoriteShow().observeForever(observer)
        verify(observer).onChanged(dummyShows)
    }
}