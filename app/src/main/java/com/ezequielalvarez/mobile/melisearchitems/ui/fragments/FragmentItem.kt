package com.ezequielalvarez.mobile.melisearchitems.ui.fragments

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ezequielalvarez.mobile.melisearchitems.R
import com.ezequielalvarez.mobile.melisearchitems.adapters.ItemsAdapter
import com.ezequielalvarez.mobile.melisearchitems.adapters.OnItemClickListener
import com.ezequielalvarez.mobile.melisearchitems.api.RetrofitService
import com.ezequielalvarez.mobile.melisearchitems.config.StatusInternet
import com.ezequielalvarez.mobile.melisearchitems.databinding.FragmentItemBinding
import com.ezequielalvarez.mobile.melisearchitems.flow.FlowFragment
import com.ezequielalvarez.mobile.melisearchitems.models.Result
import com.ezequielalvarez.mobile.melisearchitems.repository.Repository
import com.ezequielalvarez.mobile.melisearchitems.viewModels.ItemViewModel
import com.ezequielalvarez.mobile.melisearchitems.viewModels.ItemViewModelFactory

class FragmentItem : Fragment(), OnItemClickListener {
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

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemBinding.inflate(inflater, container, false)
        val view = binding.root
        validateInternet()
        searchItem()
        setData()
        onRefresh()
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

    @RequiresApi(Build.VERSION_CODES.M)
    fun validateInternet() {
        if (!(StatusInternet.isNetworkAvailable(requireContext()))) {
            binding.lnViewError.visibility = View.VISIBLE
            binding.imageError.setImageResource(R.drawable.ic_intenet)
            binding.tvError.setText(R.string.item_error_interner)
        }
    }

    fun setData() {

        binding.pullRefresh.setColorSchemeResources(R.color.yellow)
        viewModel = ViewModelProvider(this, ItemViewModelFactory(Repository(retrofitService))).get(
            ItemViewModel::class.java
        )
        binding.recyclerview.adapter = adapter

        viewModel.itemList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: ${it.results}")
            if (it.results.isNotEmpty()) {
                adapter.setItemsList(it.results)
                binding.lnViewError.visibility = View.GONE
            } else {
                adapter.setItemsList(emptyList())
                binding.lnViewError.visibility = View.VISIBLE
            }
            binding.pullRefresh.isRefreshing = false
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
            binding.lnViewError.visibility = View.VISIBLE
            binding.pullRefresh.isRefreshing = false
            binding.tvError.setText(R.string.item_error_search)
            Log.d(TAG, "onError: ${it}")
        })
    }

    fun searchItem() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                binding.pullRefresh.isRefreshing = true
                viewModel.getItems(query)
                Log.d(TAG, query)
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                return false
            }
        })
    }

    fun onRefresh() {
        binding.pullRefresh.setOnRefreshListener {
            searchItem()
            binding.pullRefresh.isRefreshing = false
        }
    }


}