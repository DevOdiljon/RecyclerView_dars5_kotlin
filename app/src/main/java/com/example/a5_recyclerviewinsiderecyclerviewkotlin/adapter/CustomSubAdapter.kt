package com.example.a5_recyclerviewinsiderecyclerviewkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.R
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.model.MemberSub

class CustomSubAdapter(private val context: Context, private  val memberSubs: List<MemberSub>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val footer = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_list_view, parent, false)
        return CustomSubHolder(footer)
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val (status) = memberSubs[position]
    }

    override fun getItemCount(): Int {
        return memberSubs.size
    }

    class CustomSubHolder(footer: View) : RecyclerView.ViewHolder(footer) {

    }
}
