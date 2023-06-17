package com.example.telegram

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import kotlin.math.log

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val login= inflater.inflate(R.layout.fragment_login, container, false)
        val loginBtn=login.findViewById<Button>(R.id.loginBtn)
        val userName=login.findViewById<EditText>(R.id.email)
        val passWord=login.findViewById<EditText>(R.id.password)
        val dataSharedPreference= activity?.getSharedPreferences("data", Context.MODE_PRIVATE)
        val user=dataSharedPreference?.getString("email","")
        val pass=dataSharedPreference?.getString("password","")

        loginBtn.setOnClickListener {
            val userData:String=userName.text.toString()
            val userPass:String=passWord.text.toString()
            if(user==userData && pass==userPass){
                val edit=dataSharedPreference.edit()
                edit.putBoolean("data",true)
                edit.apply()
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(context, "Login  successful", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(context, "Invalid UserName", Toast.LENGTH_SHORT).show()
            }
        }
        return login

    }

}