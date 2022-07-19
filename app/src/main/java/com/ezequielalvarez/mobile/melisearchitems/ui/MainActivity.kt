package com.ezequielalvarez.mobile.melisearchitems.ui


import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.ezequielalvarez.mobile.melisearchitems.*
import com.ezequielalvarez.mobile.melisearchitems.adapters.ItemsAdapter
import com.ezequielalvarez.mobile.melisearchitems.api.RetrofitService
import com.ezequielalvarez.mobile.melisearchitems.databinding.ActivityMainBinding
import com.ezequielalvarez.mobile.melisearchitems.flow.FlowFragment
import com.ezequielalvarez.mobile.melisearchitems.models.Result

import com.ezequielalvarez.mobile.melisearchitems.repository.Repository
import com.ezequielalvarez.mobile.melisearchitems.viewModels.ItemViewModel
import com.ezequielalvarez.mobile.melisearchitems.viewModels.ItemViewModelFactory


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FlowFragment.fragmentNoStack(
            supportFragmentManager!!,
            FragmentItem.newInstance()
        )

    }

}