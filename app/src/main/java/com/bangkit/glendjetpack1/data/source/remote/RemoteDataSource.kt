package com.bangkit.glendjetpack1.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bangkit.glendjetpack1.data.source.remote.api.ApiConfig
import com.bangkit.glendjetpack1.data.source.remote.api.ApiService
import com.bangkit.glendjetpack1.data.source.remote.response.ApiResponse
import com.bangkit.glendjetpack1.data.source.remote.response.FilmResponse
import com.bangkit.glendjetpack1.data.source.remote.response.ShowResponse
import com.bangkit.glendjetpack1.utils.EspressoIdlingResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import java.io.IOException
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val contentApiService: ApiService){

    private val handler = Handler(Looper.getMainLooper())



    fun getPopularFilms(): LiveData<ApiResponse<List<FilmResponse>>> {
        EspressoIdlingResource.increment()
        val resultFilmResponse = MutableLiveData<ApiResponse<List<FilmResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = contentApiService.getPopularFilms().await()
                resultFilmResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultFilmResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultFilmResponse
    }

    fun getPopularShow(): LiveData<ApiResponse<List<ShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultShowResponse = MutableLiveData<ApiResponse<List<ShowResponse>>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = contentApiService.getPopularShow().await()
                resultShowResponse.postValue(ApiResponse.success(response.result!!))
            } catch (e: IOException) {
                e.printStackTrace()
                resultShowResponse.postValue(
                    ApiResponse.error(
                        e.message.toString(),
                        mutableListOf()
                    )
                )
            }
        }
        EspressoIdlingResource.decrement()
        return resultShowResponse
    }

}