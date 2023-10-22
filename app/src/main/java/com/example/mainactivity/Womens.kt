package com.example.mainactivity

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainactivity.adapter.MenuAdapter
import com.example.mainactivity.databinding.FragmentMenuBottomSheetBinding
import com.example.mainactivity.databinding.FragmentWomenBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Womens :BottomSheetDialogFragment() {
    private lateinit var binding:FragmentWomenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWomenBinding.inflate(inflater,container,false)

        val menuFoodName = listOf(
            "Gucci Bag",
            "Gucci B&W Sandals",
            "Gucci Coat",
            "Leather Sandals",
            "Gucci Women's Slides"
        )
        val menuItemPrice = listOf("₱299", "₱299", "₱299", "₱299", "₱299")
        val menuImage =
            listOf(
                R.drawable.women1,
                R.drawable.women2,
                R.drawable.women3,
                R.drawable.women4,
                R.drawable.women5
            )
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}