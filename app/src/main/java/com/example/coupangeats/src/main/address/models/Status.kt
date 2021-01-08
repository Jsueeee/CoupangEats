package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String,
    @SerializedName("name")
    val name: String
)