package com.ramachandran.species.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.species.OnDataListeners
import com.ramachandran.species.databinding.SpeciesadapterBinding

class SpeciesAdapter(context : Context) : RecyclerView.Adapter<SpeciesAdapter.SpeciesViewHolder>() {
    val mContext = context;

    var onDataListeners : OnDataListeners?=null
    init{
        onDataListeners = mContext as OnDataListeners
    }
    var dataList : List<String>? =null
    fun setData(list : List<String>){
        dataList = list;
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpeciesViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val speciesadapterBinding = SpeciesadapterBinding.inflate(layoutInflater,parent,false)
        return SpeciesViewHolder(speciesadapterBinding,mContext)
    }
    fun onClicked(species : String){
        onDataListeners!!.onDataListen(species)
    }
    override fun getItemCount(): Int = dataList!!.size

    override fun onBindViewHolder(holder: SpeciesViewHolder, position: Int) {
        holder.bind(dataList!!.get(position))
    }
    class SpeciesViewHolder(speciesBinding : SpeciesadapterBinding,contect : Context) : RecyclerView.ViewHolder(speciesBinding.root) {
        var specBinding : SpeciesadapterBinding = speciesBinding
        val cont = contect
        fun bind(specie : String){
            specBinding.species = specie
            specBinding.speadap = SpeciesAdapter(cont)
            specBinding.executePendingBindings()
        }
    }
}