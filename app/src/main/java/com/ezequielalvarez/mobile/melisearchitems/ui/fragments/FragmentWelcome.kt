package com.ezequielalvarez.mobile.melisearchitems.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.ezequielalvarez.mobile.melisearchitems.R
import com.ezequielalvarez.mobile.melisearchitems.databinding.FragmentItemDetailBinding
import com.ezequielalvarez.mobile.melisearchitems.databinding.FragmentWelcomeBinding
import com.ezequielalvarez.mobile.melisearchitems.flow.FlowFragment


class FragmentWelcome : Fragment(), View.OnClickListener {
    private var _binding: FragmentWelcomeBinding? = null
    private val binding get() = _binding!!


    companion object {
        fun newInstance(): FragmentWelcome {
            return FragmentWelcome()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWelcomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnStart.setOnClickListener(this)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
       when(v!!.id){
           R.id.btnStart ->{
               FlowFragment.fragmentNoStack(
                   requireFragmentManager(),
                   FragmentItem.newInstance()
               )
               Log.d("start", "Ir a Buscar")
           }
       }
    }


}
