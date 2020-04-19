package com.foxhole.kotlincoroutinesbasic.network.api

import com.foxhole.kotlincoroutinesbasic.model.Photo
import retrofit2.http.GET

/**
 * Created by Musfick Jamil on 4/19/2020$.
 */

interface PhotoApi {

    @GET("/photos")
    suspend fun getPhotos() : MutableList<Photo>
}