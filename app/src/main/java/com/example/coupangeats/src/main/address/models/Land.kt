package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class Land(
    @SerializedName("addition0")
    val addition0: Addition0,
//    @SerializedName("addition1")
//    val addition1: Addition1,
//    @SerializedName("addition2")
//    val addition2: Addition2,
//    @SerializedName("addition3")
//    val addition3: Addition3,
//    @SerializedName("addition4")
//    val addition4: Addition4,
//    @SerializedName("coords")
//    val coords: Coords,
    @SerializedName("name")
    val name: String,
    @SerializedName("number1")
    val number1: String,
    @SerializedName("number2")
    val number2: String,
    @SerializedName("type")
    val type: String
)