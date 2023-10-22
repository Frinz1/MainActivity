package com.example.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainactivity.databinding.ActivityDetailsBinding

class detailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val itemNamee = intent.getStringExtra("MenuItemName")
        val itemImagee = intent.getIntExtra("MenuItemImage", 0)
        binding.DetailItemName.text = itemNamee
        binding.DetailItemImage.setImageResource(itemImagee)

        binding.imageButton3.setOnClickListener {
            finish()
        }
    }
}