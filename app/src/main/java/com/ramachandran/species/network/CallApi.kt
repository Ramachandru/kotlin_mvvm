package com.ramachandran.species.network

import com.ramachandran.species.SpeciesSingleton
import com.ramachandran.species.model.Results
import com.ramachandran.species.model.Species

typealias MapList=HashMap<String,List<Results>>

class CallApi {
    fun getSpicesList(specise : Species?) : MapList{
        val maps : MapList = MapList()
        for(result in specise!!.results){
            getSpecies(maps,result,result.species)
        }
        return maps
    }
    fun getGenderList(keys : String) : MapList{
        val lResults : List<Results>? = SpeciesSingleton.speciesSingleton!!.getAllSpeciesList().get(keys)
        val hashMap =MapList()
        for( result in lResults!!){
            getSpecies(hashMap,result,result.gender)
        }
        return hashMap
    }
    fun getSpecies(map : MapList, result : Results,key : String) : Unit{
        if(map.containsKey(key)){
            val list = map.get(key) as ArrayList
            list.add(result)
            map.put(key,list)
        }
        else{
            var list=ArrayList<Results>()
            list.add(result)
            map.put(key,list)
        }
    }
}