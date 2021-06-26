package com.bangkit.glendjetpack1.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ShowResponse(
    @SerializedName("id")
    var showId: Int = 0,
    @SerializedName("name")
    var title: String? = null,
    @SerializedName("overview")
    var description: String? = null,
    @SerializedName("first_air_date")
    var date: String? = null,
    @SerializedName("poster_path")
    var imagePath: String? = null
)
