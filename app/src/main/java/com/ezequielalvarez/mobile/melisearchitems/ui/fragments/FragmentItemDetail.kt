package com.ezequielalvarez.mobile.melisearchitems.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.ezequielalvarez.mobile.melisearchitems.R
import com.ezequielalvarez.mobile.melisearchitems.databinding.FragmentItemDetailBinding


class FragmentItemDetail : Fragment() {
    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!

    companion object {
        private var urlDetail = ""
        fun newInstance(permalink: String): FragmentItemDetail {
            urlDetail = permalink
            return FragmentItemDetail()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        loadWeb()
        onRefresh()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun onRefresh() {
        binding.pullRefresh.setOnRefreshListener {
            loadWeb()
            binding.pullRefresh.isRefreshing = false
        }
    }

    fun loadWeb() {
        val refresh = binding.pullRefresh
        refresh.setColorSchemeResources(R.color.yellow)
        refresh.isRefreshing = true
        val web = binding.webDetail
        val webSettings = web.settings
        webSettings.javaScriptEnabled = true
        web!!.webViewClient = WebViewClient()
        web!!.webChromeClient = WebChromeClient()
        web.loadUrl(urlDetail)

        web!!.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                refresh.isRefreshing = false
            }
        }
    }


}
