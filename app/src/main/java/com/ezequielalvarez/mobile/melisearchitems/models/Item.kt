package com.ezequielalvarez.mobile.melisearchitems.models

data class Item(

    val country_default_time_zone: String,
    val query: String,
    val results: List<Result>,
    val site_id: String,

)