package com.example.mainactivity.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mainactivity.databinding.CartItemBinding

class CartAdapater( private val cartItems:MutableList<String>,private val CartItemPrice:MutableList<String>,private var CartImage :MutableList<Int>) : RecyclerView.Adapter<CartAdapater.CartViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding=CartItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CartViewHolder(binding)


    }
private val itemQuantaties = IntArray(cartItems.size){1}
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int = cartItems.size


    inner class CartViewHolder (private val binding: CartItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.apply {
                val quantity = itemQuantaties[position]
                cartFoodName.text= cartItems[position]
                cartitemPrice.text = CartItemPrice[position]
                cartImage.setImageResource(CartImage[position])
                Cartquantity.text = quantity.toString()

                minusbutton.setOnClickListener {
                    decreaseQuantity(position)

                }
                plusbutton.setOnClickListener {
                    increaseQuantity(position)
                }
                deleteButton.setOnClickListener {
                    val itemPosition = adapterPosition
                    if (itemPosition != RecyclerView.NO_POSITION){
                        deleteItem(itemPosition)
                    }
                }
            }
        }
        private fun increaseQuantity(position: Int){
            if (itemQuantaties[position]<10){
                itemQuantaties[position]++
                binding.Cartquantity.text = itemQuantaties[position].toString()
            }
        }
        private fun decreaseQuantity(position: Int){
            if (itemQuantaties[position]>1){
                itemQuantaties[position]--
                binding.Cartquantity.text = itemQuantaties[position].toString()
            }
        }
        private fun deleteItem(position: Int){
            cartItems.removeAt(position)
            CartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position, cartItems.size)
        }
    }
}