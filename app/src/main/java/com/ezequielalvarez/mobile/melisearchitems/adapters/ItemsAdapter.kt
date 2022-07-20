package com.ezequielalvarez.mobile.melisearchitems.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ezequielalvarez.mobile.melisearchitems.databinding.CardviewItemBinding
import com.ezequielalvarez.mobile.melisearchitems.models.Result
import java.text.DecimalFormat


class ItemsAdapter(private val listener: OnItemClickListener): RecyclerView.Adapter<MainViewHolder>() {
    var items = mutableListOf<Result>()

    fun setItemsList(itemsList: List<Result>){
        this.items = itemsList.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = CardviewItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = items[position]
        holder.binding.title.text = item.title
        val formatea = DecimalFormat("###,###.##")
        var price = item.price.toInt()
        var priceFormated = formatea.format(price)
        if (priceFormated.toString().contains(",")){
            priceFormated = priceFormated.toString().replace(",", ".", true)
        }
        holder.binding.price.text = "$ $priceFormated"

        Glide.with(holder.itemView.context).load(item.thumbnail).into(holder.binding.imageview)

        if (position != RecyclerView.NO_POSITION) {
            holder.binding.btnDetail.setOnClickListener {
                listener.onItemClick(position, items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}

class MainViewHolder(val binding: CardviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

}