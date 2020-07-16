package com.ramachandran.species.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.species.OnDataListeners
import com.ramachandran.species.R
import com.ramachandran.species.SpeciesSingleton
import com.ramachandran.species.viewmodel.SpeciesViewModel
typealias ResourceId = R.id
class MainActivity : AppCompatActivity(), OnDataListeners {
    override fun onDataListen(data: String) {
       val lIntent= Intent(this@MainActivity,GenderActivity::class.java)
        lIntent.putExtra("species",data)
        startActivity(lIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycleView=findViewById(ResourceId.recycle)as RecyclerView
        val linearlayoutManager= LinearLayoutManager(this@MainActivity)
        val speciesAdapter = SpeciesAdapter(this@MainActivity)
        speciesAdapter.setData(mutableListOf())
        val speciesViewModel=ViewModelProviders.of(this).get(SpeciesViewModel::class.java)
        recycleView.adapter = speciesAdapter
        recycleView.layoutManager = linearlayoutManager
        speciesViewModel.getAllSpecies().observe(this,Observer(){species->
            SpeciesSingleton.getInstance().setAllSpeciesList(species)
            speciesAdapter.setData(ArrayList<String>(species.keys))
            speciesAdapter.notifyDataSetChanged()
        })
    }
    fun String.print() = Log.v(",","");
}
