package com.ezequielalvarez.mobile.melisearchitems.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.ezequielalvarez.mobile.melisearchitems.R


import com.ezequielalvarez.mobile.melisearchitems.databinding.CardviewItemBinding
import com.ezequielalvarez.mobile.melisearchitems.models.Result
import com.ezequielalvarez.mobile.melisearchitems.ui.MainActivity


class ItemsAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<MainViewHolder>() {
    lateinit var context: Context
    var movies = mutableListOf<Result>()


    fun setMovieList(moviesd: List<Result>){
        this.movies = moviesd.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = CardviewItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.title.text = movie.title

        holder.binding.price.text = "$" + String.format("%.2f", movie.price)
        Glide.with(holder.itemView.context).load(movie.thumbnail).into(holder.binding.imageview)

        if (position != RecyclerView.NO_POSITION) {
            holder.binding.cardItem.setOnClickListener {
                listener.onItemClick(position, movies[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    interface OnItemClickListener {
        fun onItemClick(
            position: Int,
            result: Result
        )
    }




}

class MainViewHolder(val binding: CardviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

}