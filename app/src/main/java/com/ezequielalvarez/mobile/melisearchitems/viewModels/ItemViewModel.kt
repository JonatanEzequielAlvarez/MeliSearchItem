package com.ezequielalvarez.mobile.melisearchitems.viewModels

import android.app.DownloadManager
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.ezequielalvarez.mobile.melisearchitems.models.Item
import com.ezequielalvarez.mobile.melisearchitems.repository.Repository


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ItemViewModel constructor(private val repository: Repository)  : ViewModel() {

    val movieList = MutableLiveData<Item>()
    val errorMessage = MutableLiveData<String>()

     fun getAllMovies(query: String) {

        val response = repository.getAllMovies(query)
        response.enqueue(object : Callback<Item> {
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                movieList.postValue(response.body())
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

    fun goTo(){

    }
}