package com.ezequielalvarez.mobile.melisearchitems.ui.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ezequielalvarez.mobile.melisearchitems.R
import com.ezequielalvarez.mobile.melisearchitems.flow.FlowFragment
import com.ezequielalvarez.mobile.melisearchitems.ui.fragments.FragmentItem
import com.ezequielalvarez.mobile.melisearchitems.ui.fragments.FragmentWelcome


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
        val firstStart = prefs.getBoolean("firstStart", true)

        if (firstStart) {
            val prefs = getSharedPreferences("prefs", MODE_PRIVATE)
            val editor = prefs.edit()
            editor.putBoolean("firstStart", false)
            editor.apply()

            FlowFragment.fragmentNoStack(
                supportFragmentManager!!,
                FragmentWelcome.newInstance()
            )

        } else {
            FlowFragment.fragmentNoStack(
                supportFragmentManager!!,
                FragmentItem.newInstance()
            )
        }


    }

}