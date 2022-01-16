package com.example.a5_recyclerviewinsiderecyclerviewkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.R
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.model.Member
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.model.MemberSub

class CustomAdapter(val context: Context, val members: List<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object{
        private val TYPE_ITEM_LIST = 0
        private val TYPE_ITEM_VIEW = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (members[position].memberSubs.size > 0) TYPE_ITEM_LIST else TYPE_ITEM_VIEW
    }

    override fun getItemCount(): Int {
        return members.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_LIST){
            val header = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_list, parent, false)
            return CustomListHolder(header)
        }
        val footer = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_view, parent, false)
        return CustomViewHolder(footer)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member = members[position]

        if (holder is CustomViewHolder){

        }
        if (holder is CustomListHolder){
            val recyclerView = holder.recyclerView
            recyclerView.layoutManager = GridLayoutManager(context, 1)

            val memberSubs = member.memberSubs
                refreshAdapter(recyclerView, memberSubs)
        }
    }

    private fun refreshAdapter(recyclerView: RecyclerView, memberSubs: List<MemberSub>) {
        val adapter = CustomSubAdapter(context, memberSubs)
        recyclerView.adapter = adapter
    }


    class CustomListHolder(header: View) : RecyclerView.ViewHolder(header) {
        val recyclerView:RecyclerView
        init {
            recyclerView = header.findViewById(R.id.recyclerView)
        }
    }

    class CustomViewHolder(footer: View) : RecyclerView.ViewHolder(footer) {

    }


}
