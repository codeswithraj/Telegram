package com.example.telegram

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

class SignUpFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val signup = inflater.inflate(R.layout.fragment_sign_up, container, false)

        val signUpName = signup.findViewById<EditText>(R.id.loginName)

        val signUpEmail = signup.findViewById<EditText>(R.id.loginEmail)

        val signUpPassword = signup.findViewById<EditText>(R.id.loginPassword)
        val signUpBtn = signup.findViewById<Button>(R.id.signupBtn)
        val sharePreference = activity?.getSharedPreferences("data", Context.MODE_PRIVATE)
        val editData = sharePreference?.edit()
        signUpBtn.setOnClickListener {
            editData?.putBoolean("data", true)
            editData?.apply()
            editData?.putString("name", signUpName.text.toString())?.commit()
            editData?.putString("email", signUpEmail.text.toString())?.commit()
            editData?.putString("password", signUpPassword.text.toString())?.commit()
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(context, "SignUp  successful", Toast.LENGTH_SHORT).show()

        }
        return signup
    }

    }