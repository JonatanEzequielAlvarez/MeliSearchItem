package com.ezequielalvarez.mobile.melisearchitems.config

import junit.framework.Assert.assertNotNull
import junit.framework.Assert.assertNull
import junit.framework.TestCase
import org.junit.Test

class StatusInternetTest{
    private var statusInternet : StatusInternet ? = null

   @Test
   fun checkNotNullStatusInternet(){
       assertNotNull(statusInternet)
   }

    @Test
    fun checkNullStatusInternet(){
        assertNull(statusInternet)
    }
}