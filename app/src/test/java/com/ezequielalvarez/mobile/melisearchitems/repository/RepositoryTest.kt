package com.ezequielalvarez.mobile.melisearchitems.repository

import com.ezequielalvarez.mobile.melisearchitems.api.RetrofitService
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RepositoryTest : TestCase() {
    //private lateinit var repository: Repository
//    @Before
//    override fun setUp(){
//        repository = Repository(RetrofitService.retrofitService!!)
//
//    }

    @Test
    fun whenIsEmptySearch() {
        val query = "moto"
        val resultado = Repository(RetrofitService.retrofitService!!).getItems(query)

        Assert.assertEquals("moto", resultado)
    }

}