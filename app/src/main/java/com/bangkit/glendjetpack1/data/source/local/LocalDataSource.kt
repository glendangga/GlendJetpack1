package com.bangkit.glendjetpack1.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.local.room.ContentDao
import javax.inject.Inject

class LocalDataSource  @Inject constructor(private val contentDao: ContentDao){



    fun getListFilms() : DataSource.Factory<Int, FilmEntity> = contentDao.getListFilms()

    fun getListFavoriteFilms() : DataSource.Factory<Int, FilmEntity> = contentDao.getListFavoriteFilms()

    fun getListShows() : DataSource.Factory<Int, ShowEntity> = contentDao.getListShows()

    fun getListFavoriteShows() : DataSource.Factory<Int, ShowEntity> = contentDao.getListFavoriteShows()

    fun getDetailFilm(movieId: Int) : LiveData<FilmEntity> = contentDao.getDetailFilmById(movieId)

    fun getDetailShow(tvShowId: Int) : LiveData<ShowEntity> = contentDao.getDetailShowById(tvShowId)

    fun insertFilms(movies: List<FilmEntity>) = contentDao.insertFilms(movies)

    fun insertShows(tvShows: List<ShowEntity>) = contentDao.insertShows(tvShows)

    fun setFavoriteFilm(film : FilmEntity) {
        film.isFavorite = !film.isFavorite
        contentDao.updateFilm(film)
    }

    fun setFavoriteShow(show : ShowEntity) {
        show.isFavorite = !show.isFavorite
        contentDao.updateShow(show)
    }

}