package com.ezequielalvarez.mobile.melisearchitems.viewModels

import com.ezequielalvarez.mobile.melisearchitems.api.RetrofitService
import com.ezequielalvarez.mobile.melisearchitems.repository.Repository
import com.google.android.gms.common.internal.Asserts.checkNull
import junit.framework.TestCase
import org.junit.Test


class ItemViewModelTest{
    lateinit var viewModel: ItemViewModel
    @Test
    fun whenIsNullSearch() {

         val retrofitService = RetrofitService.getInstance()
        viewModel = ItemViewModel(repository = Repository(retrofitService))
        val query = null
        val resultado  = query?.let { viewModel.getItems(it) }

        TestCase.assertNull(resultado)


    }

    @Test
    fun whenNoIsEmptySearch() {

        val retrofitService = RetrofitService.getInstance()
        viewModel = ItemViewModel(repository = Repository(retrofitService))
        val query = "moto"
        val resultado  = viewModel.getItems(query)

       TestCase.assertNotNull(resultado)


    }
}