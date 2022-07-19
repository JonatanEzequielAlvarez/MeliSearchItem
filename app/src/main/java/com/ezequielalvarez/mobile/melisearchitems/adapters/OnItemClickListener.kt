package com.ezequielalvarez.mobile.melisearchitems.adapters

import com.ezequielalvarez.mobile.melisearchitems.models.Result

interface OnItemClickListener {
    fun onItemClick(
        position: Int,
        result: Result
    )
}