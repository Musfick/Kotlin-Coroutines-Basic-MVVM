package com.foxhole.kotlincoroutinesbasic.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.foxhole.kotlincoroutinesbasic.repository.MainRepository
import com.foxhole.kotlincoroutinesbasic.ui.MainViewModel
import java.lang.IllegalArgumentException

/**
 * Created by Musfick Jamil on 4/19/2020$.
 */
class ViewModelFactory(private val repository: MainRepository) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(repository) as T
        }else{
            throw IllegalArgumentException("Unknown View Model Class")
        }
    }

}