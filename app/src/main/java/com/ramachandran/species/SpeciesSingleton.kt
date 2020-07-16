package com.ramachandran.species

import com.ramachandran.species.model.Results

typealias mapList = HashMap<String,List<Results>>

class SpeciesSingleton {
    private var hashMap : mapList?=null
    private var hashgenderMap : mapList?=null
    companion object{
         var speciesSingleton : SpeciesSingleton?=null
        fun getInstance() : SpeciesSingleton{
            if(speciesSingleton == null){
                synchronized(SpeciesSingleton::class.java){
                    if(speciesSingleton == null){
                        speciesSingleton = SpeciesSingleton()
                    }
                }
            }
            return speciesSingleton!!
        }
    }
    fun setAllSpeciesList(hashMap : mapList){
        this.hashMap = hashMap;
    }
    fun getAllSpeciesList() : mapList = hashMap!!
    fun setAllGenderList(hashMap : mapList){
        this.hashgenderMap = hashMap;
    }
    fun getAllGenderList() : mapList = hashgenderMap!!
}