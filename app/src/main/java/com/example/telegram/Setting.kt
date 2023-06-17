package com.example.telegram

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Setting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val userName=findViewById<TextView>(R.id.username)
        val email=findViewById<TextView>(R.id.email)
        val password=findViewById<TextView>(R.id.password)

        val sharePreference=getSharedPreferences("data", Context.MODE_PRIVATE)

        userName.text=sharePreference.getString("name","").toString()
        email.text=sharePreference.getString("email","").toString()
        password.text=sharePreference.getString("password","").toString()
    }
}