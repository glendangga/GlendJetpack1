package com.bangkit.glendjetpack1.data.source.remote.response

import com.google.gson.annotations.SerializedName


data class TestResponse<T>(
    @SerializedName("results")
    val result: List<T>? = null,
    @SerializedName("status_message")
    val statusMessage: String? = null,
    @SerializedName("status_code")
    val statusCode: Int? = null
)