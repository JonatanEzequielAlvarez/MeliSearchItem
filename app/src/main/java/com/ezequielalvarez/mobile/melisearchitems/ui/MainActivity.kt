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


class MainActivity : AppCompatActivity(){
//    private val TAG = "MainActivity"
//    private lateinit var binding: ActivityMainBinding
//
//    lateinit var viewModel: ItemViewModel
//
//    private val retrofitService = RetrofitService.getInstance()
//    val adapter = ItemsAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
                //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        FlowFragment.fragmentNoStack(
            supportFragmentManager!!,
            FragmentItem.newInstance()
        )

//        viewModel = ViewModelProvider(this, ItemViewModelFactory(Repository(retrofitService))).get(
//            ItemViewModel::class.java)
//
//        binding.recyclerview.adapter = adapter
//
//
//        viewModel.movieList.observe(this, Observer {
//            Log.d(TAG, "onCreate: ${it.results.toString()}")
//            adapter.setMovieList(it.results)
//
//
//        })
//
//        viewModel.errorMessage.observe(this, Observer {
//            Log.d(TAG, "onError: ${it}")
//        })
//        //aca esto debo meterlo en el searchView
//        viewModel.getAllMovies("Samsung s20")


    }


//
//    override fun onItemClick(position: Int, result: Result) {
//        FlowFragment.moveToWithAnimation(
//            supportFragmentManager!!,
//            FragmentItemDetail.newInstance(result.permalink)
//        )
//
////        val goToUrlGovIntent = Intent(
////            Intent.ACTION_VIEW,
////            Uri.parse(result.permalink)
////        )
////        startActivity(goToUrlGovIntent)
//    }


}