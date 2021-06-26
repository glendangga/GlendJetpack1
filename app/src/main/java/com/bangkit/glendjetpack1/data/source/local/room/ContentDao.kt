package com.bangkit.glendjetpack1.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.ShowEntity

@Dao
interface ContentDao {

    @Query("SELECT * FROM tb_film")
    fun getListFilms() : DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM tb_show")
    fun getListShows() : DataSource.Factory<Int, ShowEntity>

    @Query("SELECT * FROM tb_film WHERE isFavorite = 1")
    fun getListFavoriteFilms() : DataSource.Factory<Int, FilmEntity>

    @Query("SELECT * FROM tb_show WHERE isFavorite = 1")
    fun getListFavoriteShows() : DataSource.Factory<Int, ShowEntity>

    @Query("SELECT * FROM tb_film WHERE filmId = :filmId")
    fun getDetailFilmById(filmId: Int) : LiveData<FilmEntity>

    @Query("SELECT * FROM tb_show WHERE ShowId = :showId")
    fun getDetailShowById(showId: Int) : LiveData<ShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = FilmEntity::class)
    fun insertFilms(films: List<FilmEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE, entity = ShowEntity::class)
    fun insertShows(shows: List<ShowEntity>)

    @Update(entity = FilmEntity::class)
    fun updateFilm(film : FilmEntity)

    @Update(entity = ShowEntity::class)
    fun updateShow(shows : ShowEntity)
}