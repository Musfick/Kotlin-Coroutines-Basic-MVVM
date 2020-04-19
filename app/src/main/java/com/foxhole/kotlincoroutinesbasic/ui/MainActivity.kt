package com.foxhole.kotlincoroutinesbasic.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.foxhole.kotlincoroutinesbasic.R
import com.foxhole.kotlincoroutinesbasic.adapter.RecyclerViewAdapter
import com.foxhole.kotlincoroutinesbasic.base.BaseActivity
import com.foxhole.kotlincoroutinesbasic.model.Photo
import com.foxhole.kotlincoroutinesbasic.network.RetrofitClient
import com.foxhole.kotlincoroutinesbasic.repository.MainRepository
import com.foxhole.kotlincoroutinesbasic.util.Resource
import com.foxhole.kotlincoroutinesbasic.util.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main) {

    companion object {
        const val TAG = "Main_Tag"
    }

    private lateinit var mainViewModel: MainViewModel

    override fun onViewReady(savedInstanceState: Bundle?) {
        super.onViewReady(savedInstanceState)
        val photoApi = RetrofitClient.photoApi
        val repo = MainRepository(photoApi)
        val factory = ViewModelFactory(repo)

        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        mainViewModel.observerPhotos().observe(this, Observer {
            if (it != null){
                when(it.status){
                    Resource.Status.LOADING ->{
                        showLog(TAG,"Loading..")
                        progressBar.visibility = View.VISIBLE
                    }
                    Resource.Status.SUCCESS -> {
                        showLog(TAG, "Success")
                        progressBar.visibility = View.GONE
                        updateUI(it.data)
                    }
                    Resource.Status.ERROR -> {
                        showLog(TAG, it.message)
                        showToast(it.message)
                        progressBar.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun updateUI(data: MutableList<Photo>?) {
        data?.let {
            recycler_view.apply {
                this.layoutManager = LinearLayoutManager(this@MainActivity)
                this.setHasFixedSize(true)
                this.adapter = RecyclerViewAdapter(it)
            }
        }
    }


}
