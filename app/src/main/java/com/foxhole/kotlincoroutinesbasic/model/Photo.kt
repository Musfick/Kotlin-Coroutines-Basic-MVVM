package com.foxhole.kotlincoroutinesbasic.model


import com.google.gson.annotations.SerializedName

data class Photo(
    val albumId: Int,
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val url: String
)