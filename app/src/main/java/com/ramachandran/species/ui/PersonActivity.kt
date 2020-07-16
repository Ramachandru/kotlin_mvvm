package com.ramachandran.species.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.species.R
import com.ramachandran.species.SpeciesSingleton

class PersonActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.personactivity)
        val personRecyclerView = findViewById<RecyclerView>(R.id.person)
        val personkey=intent.getStringExtra("gender")
        val personList=SpeciesSingleton.getInstance().getAllGenderList().get(personkey)
        val persoAdapter=PersonAdapter(this@PersonActivity)
        val linearLayoutManager=LinearLayoutManager(this@PersonActivity)
        persoAdapter.setDataList(personList!!)
        personRecyclerView.layoutManager=linearLayoutManager
        personRecyclerView.adapter=persoAdapter
    }
}