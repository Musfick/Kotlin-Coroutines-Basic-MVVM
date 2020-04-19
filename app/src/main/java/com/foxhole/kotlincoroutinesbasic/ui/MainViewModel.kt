package com.foxhole.kotlincoroutinesbasic.ui

import androidx.lifecycle.*
import com.foxhole.kotlincoroutinesbasic.model.Photo
import com.foxhole.kotlincoroutinesbasic.repository.MainRepository
import com.foxhole.kotlincoroutinesbasic.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Musfick Jamil on 4/19/2020$.
 */

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _photoLiveData = MutableLiveData<Resource<MutableList<Photo>>>()

    init {
        getPhoto()
    }

    private fun getPhoto() {
        _photoLiveData.value = Resource.loading(null)
        viewModelScope.launch(Dispatchers.IO){
            _photoLiveData.postValue(mainRepository.getPhotos())
        }
    }

    fun observerPhotos() : LiveData<Resource<MutableList<Photo>>>{
        return _photoLiveData
    }
}