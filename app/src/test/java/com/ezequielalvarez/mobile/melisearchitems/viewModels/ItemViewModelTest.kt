package com.ezequielalvarez.mobile.melisearchitems.viewModels

import com.ezequielalvarez.mobile.melisearchitems.api.RetrofitService
import com.ezequielalvarez.mobile.melisearchitems.repository.Repository
import org.junit.Assert
import org.junit.Test

class ItemViewModelTest{

    @Test
    fun whenNoIsEmptySearch() {
        lateinit var viewModel: ItemViewModel
         val retrofitService = RetrofitService.getInstance()
        viewModel = ItemViewModel(repository = Repository(retrofitService))
        val query = "moto"
        val resultado  = viewModel.getItems(query)
        viewModel.itemList


        Assert.assertEquals(viewModel.itemList, viewModel.getItems(query))
    }
}