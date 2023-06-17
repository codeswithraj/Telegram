package com.example.telegram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class Account : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)
        val tabLayout=findViewById<TabLayout>(R.id.tabLayout)
        val viewPage=findViewById<ViewPager>(R.id.view_pager)
        val adpater= LoginTabAdapter(supportFragmentManager)
        adpater.addFragment(LoginFragment(),"Login")
        adpater.addFragment(SignUpFragment(),"SignUp")
        viewPage.adapter=adpater
        tabLayout.setupWithViewPager(viewPage)
    }
}