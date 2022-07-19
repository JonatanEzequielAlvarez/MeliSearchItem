package com.ezequielalvarez.mobile.melisearchitems.ui

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.ezequielalvarez.mobile.melisearchitems.R
import com.ezequielalvarez.mobile.melisearchitems.databinding.FragmentItemDetailBinding


class FragmentItemDetail: Fragment() {
    private var _binding: FragmentItemDetailBinding? = null
    private val binding get() = _binding!!


    companion object {
        private var urlDetail = ""
        fun newInstance(permalink: String): FragmentItemDetail {
            urlDetail = permalink
            return FragmentItemDetail()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val view = binding.root
        val progressDialog = ProgressDialog(activity)
        progressDialog.setIcon(R.mipmap.ic_launcher)
        progressDialog.setMessage("Cargando Información...")
        progressDialog.show()

        val web = binding.webDetail
        val webSettings = web.settings
        webSettings.javaScriptEnabled
        web!!.webViewClient = WebViewClient()
        web!!.webChromeClient = WebChromeClient()

        web.loadUrl(urlDetail)

        web!!.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                //elimina ProgressBar.
                progressDialog.dismiss()
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
