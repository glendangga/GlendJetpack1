package com.bangkit.glendjetpack1.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.local.LocalDataSource
import com.bangkit.glendjetpack1.data.source.remote.RemoteDataSource
import com.bangkit.glendjetpack1.utils.DataDummy
import com.bangkit.glendjetpack1.utils.LiveDataTestUtil
import com.bangkit.glendjetpack1.utils.PagedListUtil
import com.bangkit.glendjetpack1.vo.Resource
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.Assert
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class ContentRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val contentRepository = FakeContentRepository(remote, local)

    private val listFilmResponses = DataDummy.generateRemoteDummyFilm()
    private val filmId = listFilmResponses[0].filmId
    private val listShowResponses = DataDummy.generateRemoteDummyShow()
    private val showId = listShowResponses[0].showId
    private val filmResponse = DataDummy.generateRemoteDummyFilm()[0]
    private val showResponse = DataDummy.generateRemoteDummyShow()[0]

    private val listFilm = DataDummy.generateDummyFilm()
    private val listShow = DataDummy.generateDummyShow()
    private val film = DataDummy.generateDummyFilm()[0]
    private val show = DataDummy.generateDummyShow()[0]

    @Test
    fun getPopularFilms() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>

        Mockito.`when`(local.getListFilms()).thenReturn(dataSourceFactory)
        contentRepository.getPopularFilms()

        val filmEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyFilm()))
        Mockito.verify(local).getListFilms()
        assertNotNull(filmEntity.data)
        assertEquals(listFilm.size.toLong(), filmEntity.data?.size?.toLong())
    }

    @Test
    fun getFilmDetail(){
        val dummyFilm = MutableLiveData<FilmEntity>()
        dummyFilm.value = film
        Mockito.`when`(local.getDetailFilm(film.filmId)).thenReturn(dummyFilm)

        val data = LiveDataTestUtil.getValue(contentRepository.getFilmDetail(film.filmId))
        Mockito.verify(local).getDetailFilm(film.filmId)
        assertNotNull(data)
        assertEquals(film.filmId, data.filmId)
    }

    @Test
    fun getPopularShow(){
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>

        Mockito.`when`(local.getListShows()).thenReturn(dataSourceFactory)
        contentRepository.getPopularShow()

        val showEntity = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShow()))
        Mockito.verify(local).getListShows()
        assertNotNull(showEntity.data)
        assertEquals(listShow.size.toLong(), showEntity.data?.size?.toLong())
    }

    @Test
    fun getShowDetail(){
        val dummyShow = MutableLiveData<ShowEntity>()
        dummyShow.value = show
        Mockito.`when`(local.getDetailShow(show.showId)).thenReturn(dummyShow)

        val data = LiveDataTestUtil.getValue(contentRepository.getShowDetail(show.showId))
        Mockito.verify(local).getDetailShow(show.showId)
        assertNotNull(data)
        assertEquals(show.showId, data.showId)
    }

    @Test
    fun getListFavoriteFilms() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, FilmEntity>
        Mockito.`when`(local.getListFavoriteFilms()).thenReturn(dataSourceFactory)
        contentRepository.getListFavoriteFilms()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyFilm()))
        verify(local).getListFavoriteFilms()
        assertNotNull(courseEntities)
        assertEquals(listFilm.size.toLong(), courseEntities.data?.size?.toLong())
    }

    @Test
    fun getListFavoriteShows() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        Mockito.`when`(local.getListFavoriteShows()).thenReturn(dataSourceFactory)
        contentRepository.getListFavoriteShows()

        val courseEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyShow()))
        verify(local).getListFavoriteShows()
        assertNotNull(courseEntities)
        assertEquals(listShow.size.toLong(), courseEntities.data?.size?.toLong())
    }
}