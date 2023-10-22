package com.example.mainactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mainactivity.databinding.ActivityRegiterBinding
import com.example.pchub.Activities.DatabaseHelper
import com.example.pchub.Activities.User
import com.example.pchub.ValidationUtils

class Regiter : AppCompatActivity() {
    private lateinit var db: DatabaseHelper
    private val binding: ActivityRegiterBinding by lazy {
        ActivityRegiterBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        db = DatabaseHelper(this)

        binding.textView7.setOnClickListener {
            val intent = Intent(this,Login::class.java)
            startActivity(intent)
        }
        binding.loginbutton.setOnClickListener {
            registerUser()
    }
}

    private fun registerUser() {
        val username = binding.Name.text.toString()
        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.editTextNumberPassword.text.toString()
        val confirm = binding.passtoet.text.toString()

        if(ValidationUtils.isTextNotEmpty(username) && ValidationUtils.isTextNotEmpty(email)
            && ValidationUtils.isTextNotEmpty(password) && ValidationUtils.isTextNotEmpty(confirm)){
            if(ValidationUtils.isValidEmail(email)){
                if(password == confirm){
                    val user = User(username = username, email = email, password = password, confirm = confirm)
                    db.registerUser(user)
                    val intent = Intent(this, Login::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Account registered!", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(this, "Password Not Matched!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Invalid email format!", Toast.LENGTH_SHORT).show()
            }

        }else{
            Toast.makeText(this, "Please enter fields!", Toast.LENGTH_SHORT).show()
        }
    }
}
