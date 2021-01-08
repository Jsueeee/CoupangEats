package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("code")
    val code: Code,
    @SerializedName("land")
    val land: Land,
//    @SerializedName("name")
//    val name: String,
    @SerializedName("region")
    val region: Region
)