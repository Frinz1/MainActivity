package com.example.mainactivity.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mainactivity.R
import com.example.mainactivity.adapter.MenuAdapter
import com.example.mainactivity.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter : MenuAdapter
    private val orignalMenuFoodName = listOf(
        "Black Shoes",
        "Happy Happy Shirt",
        "Sad Happy Shirt",
        "Leather Shoes",
        "BBM Shoes",
        "New Balance XRCTU MSXRCTUD",
        "Custom Jordan 1",
        "Nike SB dunk low cut",
        "Adidas Ultrabounce",
        "Under Armour Shirt",
        "Under Armour Pants",
        "Gucci Bag",
        "Gucci B&W Sandals",
        "Gucci Coat",
        "Leather Sandals",
        "Gucci Women's Slides",
        "Khaki Children's pants",
        "Linen Baby Dress",
        "Corduroy Overalls Set",
        "Children's Wear Set",
        "Summer Romper Button Sleeveless"
    )
    private val orginalMenuItemPrice = listOf("₱299", "₱299", "₱299", "₱299", "₱299","₱299", "₱299", "₱299", "₱299", "₱299",
        "₱299", "₱299", "₱299", "₱299", "₱299","₱299", "₱299", "₱299", "₱299", "₱299","₱299")
    private val originalmenuImage =
        listOf(
            R.drawable.item1,
            R.drawable.item2,
            R.drawable.item3,
            R.drawable.item4,
            R.drawable.item5,
            R.drawable.men1,
            R.drawable.men2,
            R.drawable.men3,
            R.drawable.men4,
            R.drawable.men5,
            R.drawable.men6,
            R.drawable.women1,
            R.drawable.women2,
            R.drawable.women3,
            R.drawable.women4,
            R.drawable.women5,
            R.drawable.children1,
            R.drawable.children2,
            R.drawable.children3,
            R.drawable.children4,
            R.drawable.children5
        )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName = mutableListOf <String>()
    private val filteredMenuItemPrice = mutableListOf <String>()
    private val filteredMenuImage = mutableListOf <Int>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater,container,false)
        adapter = MenuAdapter(filteredMenuFoodName,filteredMenuItemPrice,filteredMenuImage, requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        setupSearchView()
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(orignalMenuFoodName)
        filteredMenuItemPrice.addAll(orginalMenuItemPrice)
        filteredMenuImage.addAll(originalmenuImage)

        adapter.notifyDataSetChanged()

    }

    private fun setupSearchView(){
        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query)
                return true

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }

        })
    }

    private fun filterMenuItems(query: String?) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        orignalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query.toString(),ignoreCase = true)){
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(orginalMenuItemPrice[index])
                filteredMenuImage.add(originalmenuImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }


    companion object {

    }
}



