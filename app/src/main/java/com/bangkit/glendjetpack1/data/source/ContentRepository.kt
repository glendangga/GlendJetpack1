package com.bangkit.glendjetpack1.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.NetworkBoundResource
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.local.LocalDataSource
import com.bangkit.glendjetpack1.data.source.remote.RemoteDataSource
import com.bangkit.glendjetpack1.data.source.remote.response.ApiResponse
import com.bangkit.glendjetpack1.data.source.remote.response.FilmResponse
import com.bangkit.glendjetpack1.data.source.remote.response.ShowResponse
import com.bangkit.glendjetpack1.vo.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ContentRepository @Inject constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) : ContentDataSource {




    override fun getPopularFilms(): LiveData<Resource<PagedList<FilmEntity>>> {
        return object : NetworkBoundResource<PagedList<FilmEntity>, List<FilmResponse>>() {
            public override fun loadFromDB(): LiveData<PagedList<FilmEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListFilms(), config).build()
            }

            override fun shouldFetch(data: PagedList<FilmEntity>?): Boolean =
                data == null || data.isEmpty()


            public override fun createCall(): LiveData<ApiResponse<List<FilmResponse>>> =
                remoteDataSource.getPopularFilms()

            public override fun saveCallResult(data: List<FilmResponse>) {
                val filmList = ArrayList<FilmEntity>()
                for (item in data) {
                    val film = FilmEntity(
                        null,
                        item.filmId,
                        item.title,
                        item.description,
                        item.date,
                        item.imagePath,
                        false
                    )
                    filmList.add(film)
                }

                localDataSource.insertFilms(filmList)
            }

        }.asLiveData()
    }


    override fun getFilmDetail(filmId: Int): LiveData<FilmEntity> =
        localDataSource.getDetailFilm(filmId)


    override fun getPopularShow(): LiveData<Resource<PagedList<ShowEntity>>> {
        return object : NetworkBoundResource<PagedList<ShowEntity>, List<ShowResponse>>() {
            public override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder().apply {
                    setEnablePlaceholders(false)
                    setInitialLoadSizeHint(4)
                    setPageSize(4)
                }.build()
                return LivePagedListBuilder(localDataSource.getListShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean =
                data == null || data.isEmpty()


            public override fun createCall(): LiveData<ApiResponse<List<ShowResponse>>> =
                remoteDataSource.getPopularShow()

            public override fun saveCallResult(data: List<ShowResponse>) {
                val showList = ArrayList<ShowEntity>()
                for (item in data) {
                    val show = ShowEntity(
                        null,
                        item.showId,
                        item.title,
                        item.description,
                        item.date,
                        item.imagePath,
                        false
                    )
                    showList.add(show)
                }

                localDataSource.insertShows(showList)
            }

        }.asLiveData()
    }


    override fun getShowDetail(showId: Int): LiveData<ShowEntity> =
        localDataSource.getDetailShow(showId)


    override fun getListFavoriteFilms(): LiveData<PagedList<FilmEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getListFavoriteFilms(), config).build()
    }

    override fun getListFavoriteShows(): LiveData<PagedList<ShowEntity>> {
        val config = PagedList.Config.Builder().apply {
            setEnablePlaceholders(false)
            setInitialLoadSizeHint(4)
            setPageSize(4)
        }.build()
        return LivePagedListBuilder(localDataSource.getListFavoriteShows(), config).build()
    }

    override fun setFavoriteFilm(film: FilmEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setFavoriteFilm(film)
        }
    }

    override fun setFavoriteShow(show: ShowEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.setFavoriteShow(show)
        }
    }
}