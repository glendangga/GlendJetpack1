package com.bangkit.glendjetpack1.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class FilmResponse (
        @SerializedName("id")
        var filmId: Int = 0,
        @SerializedName("title")
        var title: String? = null,
        @SerializedName("overview")
        var description: String? = null,
        @SerializedName("release_date")
        var date: String? = null,
        @SerializedName("poster_path")
        var imagePath: String? = null
)