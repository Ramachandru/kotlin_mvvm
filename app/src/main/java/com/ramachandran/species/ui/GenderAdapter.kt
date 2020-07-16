package com.ramachandran.species.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.species.OnDataListeners
import com.ramachandran.species.databinding.GenderadapterBinding

class GenderAdapter(context : Context) : RecyclerView.Adapter<GenderAdapter.GenderViewHolder>()
{
    val mContext : Context=context
    var OnDataLiten : OnDataListeners?=null
    var dataList : List<String>?=null
    init {
        OnDataLiten = mContext as OnDataListeners
    }
    fun setData(dataList : List<String>){
        this.dataList = dataList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenderViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        val genderadapterBinding = GenderadapterBinding.inflate(layoutInflater,parent,false)
        return GenderViewHolder(genderadapterBinding,mContext!!)
    }

    override fun getItemCount(): Int  =dataList!!.size
    fun OnClikedData(data : String){
        OnDataLiten!!.onDataListen(data)
    }
    override fun onBindViewHolder(holder: GenderViewHolder, position: Int) {
        holder.showValue(dataList!!.get(position))
    }
    class GenderViewHolder(genderBind : GenderadapterBinding,conte : Context) : RecyclerView.ViewHolder(genderBind.root){
        val conxt : Context = conte
        val genderBinder = genderBind
        fun showValue(sName : String): Unit{
            genderBinder.gender = sName
            genderBinder.genderInstance= GenderAdapter(conxt)
            genderBinder.executePendingBindings()
        }
    }

}