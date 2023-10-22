package com.example.mainactivity

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainactivity.adapter.MenuAdapter
import com.example.mainactivity.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment :BottomSheetDialogFragment() {
    private lateinit var binding:FragmentMenuBottomSheetBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater,container,false)

        val menuFoodName = listOf(
            "Black Shoes",
            "Happy Happy Shirt",
            "Sad Happy Shirt",
            "Leather Shoes",
            "BBM Shoes"
        )
        val menuItemPrice = listOf("₱299", "₱299", "₱299", "₱299", "₱299")
        val menuImage =
            listOf(
                R.drawable.item1,
                R.drawable.item2,
                R.drawable.item3,
                R.drawable.item4,
                R.drawable.item5
            )
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}