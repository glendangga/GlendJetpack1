package com.bangkit.glendjetpack1.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.glendjetpack1.data.ShowEntity
import com.bangkit.glendjetpack1.data.source.ContentRepository
import com.bangkit.glendjetpack1.utils.DataDummy
import javax.inject.Inject

class DetailShowViewModel @Inject constructor(private val contentRepository: ContentRepository) : ViewModel() {

    val showId = MutableLiveData<Int>()

    fun setSelectedCourse(showId: Int) {
        this.showId.value = showId
    }

    fun getCourse(showId: Int): LiveData<ShowEntity> = contentRepository.getShowDetail(showId)

    fun setFavoriteShow(show: ShowEntity){
        contentRepository.setFavoriteShow(show)
    }

}