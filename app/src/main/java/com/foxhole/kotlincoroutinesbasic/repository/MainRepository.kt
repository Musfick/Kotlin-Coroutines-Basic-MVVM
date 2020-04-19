package com.foxhole.kotlincoroutinesbasic.repository


import com.foxhole.kotlincoroutinesbasic.model.Photo
import com.foxhole.kotlincoroutinesbasic.network.api.PhotoApi
import com.foxhole.kotlincoroutinesbasic.util.Resource
import com.foxhole.kotlincoroutinesbasic.util.ResponseHandler
import java.lang.Exception

/**
 * Created by Musfick Jamil on 4/19/2020$.
 */

class MainRepository(private val photoApi: PhotoApi){

    private val responseHandler = ResponseHandler()

    suspend fun getPhotos() : Resource<MutableList<Photo>> {

        return try {
            responseHandler.handleSuccess(photoApi.getPhotos())
        }catch (e: Exception){
            responseHandler.handleException(e)
        }
    }
}