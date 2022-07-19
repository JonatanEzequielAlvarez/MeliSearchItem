package com.ezequielalvarez.mobile.melisearchitems.flow

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ezequielalvarez.mobile.melisearchitems.R

object FlowFragment {
    //aca lo mando al otro fragment sin que quede en pila (stack)
    fun fragmentNoStack(requireFragmentManager: FragmentManager, fragment: Fragment) {
        requireFragmentManager
            .beginTransaction()
            .replace(R.id.fragments, fragment)
            .commitAllowingStateLoss()
    }

    ///para volver atras aun fragment y poder volver
    fun fragmentWithStack(requireFragmentManager: FragmentManager, fragment: Fragment) {
        requireFragmentManager
            .beginTransaction()
            .replace(R.id.fragments, fragment)
            .addToBackStack(null)
            .commitAllowingStateLoss()
    }
}