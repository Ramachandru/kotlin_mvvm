package com.ramachandran.species.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.species.OnDataListeners
import com.ramachandran.species.R
import com.ramachandran.species.SpeciesSingleton
import com.ramachandran.species.model.Results
import com.ramachandran.species.network.CallApi

class GenderActivity :AppCompatActivity(),OnDataListeners{
    override fun onDataListen(data: String) {
        val lIntent= Intent(this@GenderActivity,PersonActivity::class.java)
        lIntent.putExtra("gender",data)
        startActivity(lIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.genderactivity)
        val key=intent.getStringExtra("species")
        val value=CallApi().getGenderList(key)
        SpeciesSingleton.speciesSingleton!!.setAllGenderList(value)
        val recyclegen=findViewById<RecyclerView>(R.id.recyclegen)
        val linearLayoutManager=LinearLayoutManager(this@GenderActivity)
        val genderAdapter = GenderAdapter(this@GenderActivity)
        genderAdapter.setData(ArrayList<String>(value.keys))
        recyclegen.layoutManager=linearLayoutManager
        recyclegen.adapter=genderAdapter
    }

}