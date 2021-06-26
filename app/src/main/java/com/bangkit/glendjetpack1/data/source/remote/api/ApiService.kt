package com.bangkit.glendjetpack1.data.source.remote.api

import com.bangkit.glendjetpack1.data.source.remote.response.FilmResponse
import com.bangkit.glendjetpack1.data.source.remote.response.ShowResponse
import com.bangkit.glendjetpack1.data.source.remote.response.TestResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getPopularFilms(
            @Query("api_key") apiKey: String = "796d692190ccd646faefa2fa74bc50b4"
    ) : Call<TestResponse<FilmResponse>>

    @GET("movie/{movie_id}")
    fun getDetailFilm(
            @Path("movie_id") filmId: Int,
            @Query("api_key") apiKey: String = "796d692190ccd646faefa2fa74bc50b4"
    ) : Call<FilmResponse>

    @GET("tv/popular")
    fun getPopularShow(
            @Query("api_key") apiKey: String = "796d692190ccd646faefa2fa74bc50b4"
    ) : Call<TestResponse<ShowResponse>>

    @GET("tv/{tv_id}")
    fun getDetailShow(
            @Path("tv_id") showId: Int,
            @Query("api_key") apiKey: String = "796d692190ccd646faefa2fa74bc50b4"
    ) : Call<ShowResponse>
}