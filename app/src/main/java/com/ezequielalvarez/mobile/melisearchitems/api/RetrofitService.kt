package com.ezequielalvarez.mobile.melisearchitems.api



import com.ezequielalvarez.mobile.melisearchitems.models.Item

import retrofit2.Call

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("search?")
     fun getItems(@Query("q") q: String) : Call<Item>

    companion object {

        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    //.baseUrl("https://api.mercadolibre.com/sites/")
                    .baseUrl("https://api.mercadolibre.com/sites/MLA/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}