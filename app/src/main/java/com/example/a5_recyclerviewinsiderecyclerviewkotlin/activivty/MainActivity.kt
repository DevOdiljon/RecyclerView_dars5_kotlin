package com.example.a5_recyclerviewinsiderecyclerviewkotlin.activivty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.R
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.adapter.CustomAdapter
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.model.Member
import com.example.a5_recyclerviewinsiderecyclerviewkotlin.model.MemberSub
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = prepapeMemberList()
        refreshAdapter(members)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(this, members)
        recyclerView.adapter = adapter

    }

    private fun prepapeMemberList(): List<Member> {
        val members =  ArrayList<Member>()
        for (i in 0..29 step 1){
            if (i == 6 || i == 15 || i == 20 || i == 28){
                members.add(Member("Odilbek $i", "Odilbek $i", prepapeMemberSubList()))
            } else {
                members.add(Member("Odilbek $i", "Odilbek $i", emptyList()))
            }
        }

        return members
    }

    private fun prepapeMemberSubList(): List<MemberSub> {
        val members = ArrayList<MemberSub>()
        for (i in 0..5 step 1){
            members.add(MemberSub("offline"))
        }
        return members
    }

    fun initViews(){
        recyclerView.layoutManager = GridLayoutManager(this, 1)
    }

}