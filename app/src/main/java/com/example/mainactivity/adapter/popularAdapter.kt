package com.example.mainactivity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.databinding.PopularItemBinding

class popularAdapter (private val items:List<String>,private val price:List<String>, private val image:List<Int>): RecyclerView.Adapter<popularAdapter.popularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): popularViewHolder {
        return popularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: popularViewHolder, position: Int) {
val item = items[position]
        val images = image[position]
        val price = price [position]
        holder.bind(item,price,images)

    }
    override fun getItemCount(): Int {
        return items.size
    }
    class popularViewHolder (private val binding:PopularItemBinding) : RecyclerView.ViewHolder(binding.root){
        private val imagesView = binding.cartImage
        fun bind(item: String,price:String, images: Int) {
            binding.item1name.text = item
            binding.item1price.text = price
            imagesView.setImageResource(images)
        }

    }
}