package com.example.gabrielrosa.retrofitwithkotlin.apidatasource


import com.example.gabrielrosa.retrofitwithkotlin.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by gabrielrosa on 06/01/18.
 */
interface ApiDataSource {

    @GET("people/{id}")
    fun user(@Path("id") id: Int = 2): Call<UserResponse>
}