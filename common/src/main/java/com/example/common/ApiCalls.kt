package com.example.common

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCalls {

    @Headers("api-key:$API_KEY")
    @GET("sections")
    fun getSections(): Call<Any>

    @Headers("api-key:$API_KEY")
    @GET("{id}")
    fun getCurrentPath(
        @Path(value = "id") id: String,
        @Query("show-fields") fields: String = "all"
    ): Call<Any>
}