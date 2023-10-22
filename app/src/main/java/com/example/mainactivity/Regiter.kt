package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mainactivity.databinding.ActivityRegiterBinding

class Regiter : AppCompatActivity() {
    private val binding: ActivityRegiterBinding by lazy {
        ActivityRegiterBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.textView7.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
        binding.loginbutton.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
    }
}