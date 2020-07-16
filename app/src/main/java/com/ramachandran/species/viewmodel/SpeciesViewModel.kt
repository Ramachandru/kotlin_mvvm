package com.ramachandran.species.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ramachandran.species.model.Results
import com.ramachandran.species.model.Species
import com.ramachandran.species.network.Api
import com.ramachandran.species.network.CallApi
import com.ramachandran.species.ui.PersonAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SpeciesViewModel : ViewModel(){
    private val mutableLiveData : MutableLiveData<HashMap<String,List<Results>>> by lazy{
         getData()
        MutableLiveData<HashMap<String,List<Results>>>()
    }
    var callApi : CallApi?=null;
    fun getRetrofit() : Retrofit =Retrofit.Builder()
            .baseUrl(Api.BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun getAllSpecies() = mutableLiveData
    fun PersonAdapter.Companion.dataFinder(){

    }
    fun getData() : Unit{
        callApi= CallApi()
        val api = getRetrofit().create(Api::class.java)
        val call : Call<Species> = api.getSpecies()
        call.enqueue(object : Callback<Species>{
            override fun onFailure(call: Call<Species>, t: Throwable) {
                Log.v("","ERROR : "+t.message)
            }

            override fun onResponse(call: Call<Species>, response: Response<Species>) {
                mutableLiveData?.value = callApi?.getSpicesList(response.body())
            }

        })
    }

}