package com.example.gabrielrosa.retrofitwithkotlin.apidatasource

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by gabrielrosa on 06/01/18.
 */
class ApiDataSourceImpl {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.co/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    fun apiDataSource(): ApiDataSource {
        return retrofit.create(ApiDataSource::class.java)
    }
}