package com.foxhole.kotlincoroutinesbasic.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Musfick Jamil on 4/19/2020$.
 * **/

abstract class BaseActivity(private val layoutId : Int) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        onViewReady(savedInstanceState)
    }

    @CallSuper
    protected open fun onViewReady(savedInstanceState: Bundle?){

    }

    protected open fun showLog(tag: String, any: Any?){
        Log.d(tag, any.toString())
    }

    protected open fun showToast(msg: String?){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}

