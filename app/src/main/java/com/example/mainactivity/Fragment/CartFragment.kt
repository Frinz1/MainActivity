package com.example.mainactivity.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainactivity.CongratsBottomSheet
import com.example.mainactivity.PayOutActivity
import com.example.mainactivity.R
import com.example.mainactivity.adapter.CartAdapater
import com.example.mainactivity.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)

        val cartFoodName = listOf(
            "Black Shoes",
            "Happy Happy Shirt",
            "Sad Happy Shirt",
            "Leather Shoes",
            "BBM Shoes"
        )
        val CartItemPrice = listOf("₱299", "₱299", "₱299", "₱299", "₱299")
        val cartImage =
            listOf(
                R.drawable.item1,
                R.drawable.item2,
                R.drawable.item3,
                R.drawable.item4,
                R.drawable.item5
            )
    val adapter = CartAdapater(ArrayList(cartFoodName),ArrayList(CartItemPrice),ArrayList(cartImage))
        binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.cartRecyclerView.adapter = adapter
        binding.proceedButton.setOnClickListener {
        val intent =  Intent(requireContext(),PayOutActivity::class.java)
        startActivity(intent)
        }
        return binding.root
}
    companion object {

    }
}