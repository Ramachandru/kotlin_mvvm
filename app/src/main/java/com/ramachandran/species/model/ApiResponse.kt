package com.ramachandran.species.model

data class Species(val info: Info,
                   val results: ArrayList<Results>){

}
data class Info(val count : Int,
                val pages :Int,
                val next : String){

}
data class Results(val name : String,
                   val status : String,
                   val species : String,
                   val gender : String,
                   val type : String,
                   val origin : Origin,
                   val location : Location,
                   val image : String,
                   val created : String){

}
data class Origin(val name  :String,
                  val url : String){

}
data class Location(val name: String,
                    val url: String){

}