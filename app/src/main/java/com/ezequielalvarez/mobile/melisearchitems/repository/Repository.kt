package com.ezequielalvarez.mobile.melisearchitems.repository

import com.ezequielalvarez.mobile.melisearchitems.api.RetrofitService

class Repository constructor(private val retrofitService: RetrofitService) {

     fun getItems(query: String) = retrofitService.getItems(query)
}