package com.example.telegram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val  data = arrayListOf<DataModal>(
            DataModal("Aimit","College Patna","https://images.pexels.com/photos/516541/pexels-photo-516541.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("College","Admission Open","https://images.pexels.com/photos/3879071/pexels-photo-3879071.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("Patna","Patna Admission Open","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQVDqZu78uhKwsUyNIdiQNG0Q7ptSaxx2u8pRXrViD31A&s"),
            DataModal("Bihar","College Patna","https://images.pexels.com/photos/443446/pexels-photo-443446.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("India","Admission Open","https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/v1013-p-0019d-01-ksi8b5jn.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=105acc73dbd66de4e097301c10eb6af5"),
            DataModal("Edugaon","Patna Admission Open","https://images.pexels.com/photos/1433052/pexels-photo-1433052.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("Aimit","College Patna","https://images.pexels.com/photos/1198802/pexels-photo-1198802.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("College","Admission Open","https://images.pexels.com/photos/884788/pexels-photo-884788.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("Patna","Patna Admission Open","https://images.pexels.com/photos/60597/dahlia-red-blossom-bloom-60597.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("Aimit","College Patna","https://images.pexels.com/photos/372166/pexels-photo-372166.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("College","Admission Open","https://images.pexels.com/photos/45853/grey-crowned-crane-bird-crane-animal-45853.jpeg?auto=compress&cs=tinysrgb&w=600"),
            DataModal("Edugaon","Patna Admission Open","https://images.pexels.com/photos/45911/peacock-plumage-bird-peafowl-45911.jpeg?auto=compress&cs=tinysrgb&w=600")
        )
        val listView=findViewById<ListView>(R.id.listView)
        val  adapter= CustomAdapter(this,data)
        listView.adapter=adapter


        val drawerLayout=findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView=findViewById<NavigationView>(R.id.nav_View)

        toggle= ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {
            when (it.itemId){
                R.id.nav_home-> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT).show()
                R.id.nav_message->startActivity(Intent(this,MessageActivity::class.java))
                R.id.nav_setting-> startActivity(Intent(this,Setting::class.java))
                R.id.nav_login-> startActivity(Intent(this,Account::class.java))
                R.id.nav_rate_us-> Toast.makeText(applicationContext, "Clicked Rate Us", Toast.LENGTH_SHORT).show()
                R.id.nav_share-> Toast.makeText(applicationContext, "Clicked Share", Toast.LENGTH_SHORT).show()
                R.id.nav_sync-> Toast.makeText(applicationContext, "Clicked Sync", Toast.LENGTH_SHORT).show()
                R.id.nav_trace-> Toast.makeText(applicationContext, "Clicked Trace", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
           return true
        }
        return super.onOptionsItemSelected(item)


    }
}

