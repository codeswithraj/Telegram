package com.example.telegram

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class CustomAdapter(val context: Context, val datalist:ArrayList<DataModal>): BaseAdapter() {
    override fun getCount(): Int {
        return datalist.size
    }

    override fun getItem(p0: Int): Any {
        return datalist.size
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView= LayoutInflater.from(context).inflate(R.layout.custom_list,p2,false)
        val icon=rowView.findViewById<ImageView>(R.id.icon)
        val data=datalist[p0]
        Glide.with(context).load(data.icon).error(R.drawable.ic_launcher_background).into(icon);
        val title=rowView.findViewById<TextView>(R.id.title)
        val description=rowView.findViewById<TextView>(R.id.description)
        title.setText(data.title)
        description.setText(data.description)
        return rowView
    }

}