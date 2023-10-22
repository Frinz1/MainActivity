package com.example.mainactivity.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.mainactivity.Childrens
import com.example.mainactivity.MenuBottomSheetFragment
import com.example.mainactivity.R
import com.example.mainactivity.Womens
import com.example.mainactivity.adapter.popularAdapter
import com.example.mainactivity.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container, false)

        binding.textView5.setOnClickListener {
            val bottomSheetDialog = MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        binding.textView9.setOnClickListener {
            val bottomSheetDialog = Womens()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        binding.textView10.setOnClickListener {
            val bottomSheetDialog = Childrens()
            bottomSheetDialog.show(parentFragmentManager,"Test")
        }
        return binding.root




    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.slide1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide2, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide3, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide4, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide5, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide6, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide7, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide8, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slides9, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.slide10, ScaleTypes.FIT))

        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        imageSlider.setItemClickListener(object :ItemClickListener{
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })
        val itemName = listOf("Black Shoes","Happy Happy Shirt","Sad Happy Shirt","Leather Shoes","BBM Shoes")
        val Price = listOf("₱299","₱299","₱299","₱299","₱299")
        val popularItemImages =
            listOf(R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,R.drawable.item5)
val adapter = popularAdapter(itemName,Price,popularItemImages)
        binding.PopularRecyclerView.layoutManager =LinearLayoutManager(requireContext())
        binding.PopularRecyclerView.adapter = adapter
    }
    companion object {

    }
}