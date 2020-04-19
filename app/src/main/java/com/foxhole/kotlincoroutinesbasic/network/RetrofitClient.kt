package com.foxhole.kotlincoroutinesbasic.network

import com.foxhole.kotlincoroutinesbasic.network.api.PhotoApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Musfick Jamil on 4/19/2020$.
 */

object RetrofitClient {

    val photoApi : PhotoApi by lazy {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@lazy retrofit.create(PhotoApi::class.java)
    }
}