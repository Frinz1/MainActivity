package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mainactivity.databinding.ActivityLoginBinding
import com.example.pchub.Activities.DatabaseHelper
import com.example.pchub.ValidationUtils

class  Login : AppCompatActivity() {
    private lateinit var db: DatabaseHelper
    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        db = DatabaseHelper(this)

        binding.textView5.setOnClickListener {
            val intent = Intent(this,Regiter::class.java)
            startActivity(intent)
        }
        binding.loginbutton.setOnClickListener{
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            val password = binding.editTextNumberPassword.text.toString().trim()

            if(ValidationUtils.isTextNotEmpty(email) && ValidationUtils.isTextNotEmpty(password)){
                if(ValidationUtils.isValidEmail(email)){
                    val isSuccess = db.loginUser(email, password)
                    if(isSuccess){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }else{
                        Toast.makeText(this, "Invalid email or password!", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this, "Invalid format!", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "Please enter fields!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}

