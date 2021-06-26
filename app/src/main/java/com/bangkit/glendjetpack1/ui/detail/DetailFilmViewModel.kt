package com.bangkit.glendjetpack1.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.utils.DataDummy
import javax.inject.Inject

class DetailFilmViewModel @Inject constructor(private val contentRepository: ContentRepository) : ViewModel() {

    //    private var filmId: Int? = null
    val filmId = MutableLiveData<Int>()

    fun setSelectedCourse(filmId: Int) {
        this.filmId.value = filmId
    }

    fun getCourse(filmId: Int): LiveData<FilmEntity> = contentRepository.getFilmDetail(filmId)

    fun setFavoriteFilm(film: FilmEntity){
        contentRepository.setFavoriteFilm(film)
    }
}