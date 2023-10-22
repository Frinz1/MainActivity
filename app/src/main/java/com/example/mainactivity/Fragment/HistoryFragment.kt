package com.example.mainactivity.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainactivity.R
import com.example.mainactivity.adapter.BuyAgainAdapter
import com.example.mainactivity.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(layoutInflater,container, false)
        setupRecyclerView()
        return binding.root
    }
private fun setupRecyclerView(){
    val buyAgainFoodName = arrayListOf("Food 2","Food 2","Food 3")
    val buyAgainFoodPrice = arrayListOf("P299","P299","P299")
    val buyAgainFoodImage = arrayListOf(R.drawable.item1,R.drawable.item5,R.drawable.item4)
    buyAgainAdapter = BuyAgainAdapter(buyAgainFoodName,buyAgainFoodPrice,buyAgainFoodImage)
    binding.BuyAgainRecyclerView.adapter = buyAgainAdapter
    binding.BuyAgainRecyclerView.layoutManager= LinearLayoutManager(requireContext())
}
    companion object {
    }
}