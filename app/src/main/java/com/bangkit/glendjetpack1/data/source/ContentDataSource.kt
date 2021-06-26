package com.bangkit.glendjetpack1.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.vo.Resource


interface ContentDataSource {

    fun getPopularFilms(): LiveData<Resource<PagedList<FilmEntity>>>

    fun getListFavoriteFilms(): LiveData<PagedList<FilmEntity>>

    fun getFilmDetail(filmId: Int): LiveData<FilmEntity>

    fun getPopularShow(): LiveData<Resource<PagedList<ShowEntity>>>

    fun getListFavoriteShows(): LiveData<PagedList<ShowEntity>>

    fun getShowDetail(showId: Int): LiveData<ShowEntity>

    fun setFavoriteFilm(film: FilmEntity)

    fun setFavoriteShow(show: ShowEntity)
}