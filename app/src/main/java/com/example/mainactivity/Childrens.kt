package com.example.mainactivity

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainactivity.adapter.MenuAdapter
import com.example.mainactivity.databinding.FragmentChildrensBinding
import com.example.mainactivity.databinding.FragmentMenuBottomSheetBinding
import com.example.mainactivity.databinding.FragmentWomenBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class Childrens :BottomSheetDialogFragment() {
    private lateinit var binding:FragmentChildrensBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChildrensBinding.inflate(inflater,container,false)

        val menuFoodName = listOf(
            "Khaki Children's pants",
            "Linen Baby Dress",
            "Corduroy Overalls Set",
            "Children's Wear Set",
            "Summer Romper Button Sleeveless"
        )
        val menuItemPrice = listOf("₱299", "₱299", "₱299", "₱299", "₱299")
        val menuImage =
            listOf(
                R.drawable.children1,
                R.drawable.children2,
                R.drawable.children3,
                R.drawable.children4,
                R.drawable.children5
            )
        val adapter = MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPrice),ArrayList(menuImage),requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter
        return binding.root
    }

    companion object {

    }
}