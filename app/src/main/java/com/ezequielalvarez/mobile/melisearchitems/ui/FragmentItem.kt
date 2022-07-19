package com.ezequielalvarez.mobile.melisearchitems.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ezequielalvarez.mobile.melisearchitems.R
import com.ezequielalvarez.mobile.melisearchitems.adapters.ItemsAdapter
import com.ezequielalvarez.mobile.melisearchitems.api.RetrofitService
import com.ezequielalvarez.mobile.melisearchitems.databinding.FragmentItemBinding
import com.ezequielalvarez.mobile.melisearchitems.databinding.FragmentItemDetailBinding
import com.ezequielalvarez.mobile.melisearchitems.flow.FlowFragment
import com.ezequielalvarez.mobile.melisearchitems.models.Result
import com.ezequielalvarez.mobile.melisearchitems.repository.Repository
import com.ezequielalvarez.mobile.melisearchitems.viewModels.ItemViewModel
import com.ezequielalvarez.mobile.melisearchitems.viewModels.ItemViewModelFactory
import kotlin.concurrent.fixedRateTimer

class FragmentItem : Fragment(), ItemsAdapter.OnItemClickListener {
    private val TAG = "FragmentItem"
    private var _binding: FragmentItemBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: ItemViewModel

    private val retrofitService = RetrofitService.getInstance()
    val adapter = ItemsAdapter(this)

    companion object {
        fun newInstance(): FragmentItem {
            return FragmentItem()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        val view = binding.root
        val refresh = binding.pullRefresh

        viewModel = ViewModelProvider(this, ItemViewModelFactory(Repository(retrofitService))).get(
            ItemViewModel::class.java
        )

        binding.recyclerview.adapter = adapter


        viewModel.movieList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: ${it.results.toString()}")
            adapter.setMovieList(it.results)

           refresh.isRefreshing = false
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onError: ${it}")
        })
        //aca esto debo meterlo en el searchView
        //viewModel.getAllMovies("Samsung s20")


        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                refresh.isRefreshing = true
                viewModel.getAllMovies(query)
                Log.d(TAG, query)
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {

                return false
            }
        })


        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onItemClick(position: Int, result: Result) {
        FlowFragment.fragmentWithStack(
            requireFragmentManager(),
            FragmentItemDetail.newInstance(result.permalink)
        )

    }

}