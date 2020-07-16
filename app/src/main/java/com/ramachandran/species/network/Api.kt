package com.ramachandran.species.network

import com.ramachandran.species.model.Species
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    companion object{
        const val BASEURL : String ="https://rickandmortyapi.com/api/"
    }
    @GET("character/")
    fun getSpecies() : Call<Species>
}