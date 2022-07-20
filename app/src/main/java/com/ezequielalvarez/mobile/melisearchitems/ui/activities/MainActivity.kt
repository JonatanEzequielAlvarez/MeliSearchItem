package com.ezequielalvarez.mobile.melisearchitems.ui.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ezequielalvarez.mobile.melisearchitems.R
import com.ezequielalvarez.mobile.melisearchitems.flow.FlowFragment
import com.ezequielalvarez.mobile.melisearchitems.ui.fragments.FragmentItem


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