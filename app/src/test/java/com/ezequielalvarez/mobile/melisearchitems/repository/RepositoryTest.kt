package com.ezequielalvarez.mobile.melisearchitems.repository

import com.ezequielalvarez.mobile.melisearchitems.api.RetrofitService
import junit.framework.TestCase
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RepositoryTest{
    private var repository: RetrofitService? = RetrofitService.retrofitService


    @Test
    fun whenIsNull() {
        val query = null
        val resultado = query?.let { repository?.getItems(it) }

        assertNull(resultado)
    }

    @Test
    fun whenNoIsNull() {
        val query = "moto"
        val resultado = repository?.getItems(query)

        assertNotNull(resultado)
    }

}