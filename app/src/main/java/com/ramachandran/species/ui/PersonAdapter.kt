package com.ramachandran.species.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ramachandran.species.databinding.PersonadapterBinding
import com.ramachandran.species.model.Results
import com.squareup.picasso.Picasso

class PersonAdapter(context : Context) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>(){
    companion object {
        @JvmStatic
        @BindingAdapter("profileImage")
        fun loadImage(view: ImageView, profileImageUrl: String) {
            Picasso.with(view.context)
                .load(profileImageUrl)
                .into(view)
        }
    }
    val mContext =context

    var datList : List<Results>?=null

    fun setDataList(datList : List<Results>){
        this.datList = datList
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):PersonViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val personadapterBinding = PersonadapterBinding.inflate(layoutInflater,parent,false)
        return PersonViewHolder(personadapterBinding,mContext)
    }

    override fun getItemCount(): Int =datList!!.size

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val result=datList!!.get(position)
        holder.bind(result)
    }
    class PersonViewHolder(personaBindingx : PersonadapterBinding,cxt : Context) : RecyclerView.ViewHolder(personaBindingx.root){
       val personaBinding = personaBindingx
        val conxt : Context =cxt
        fun bind(result : Results) : Unit{
            personaBinding.person =result
            personaBinding.executePendingBindings()
        }
    }


}