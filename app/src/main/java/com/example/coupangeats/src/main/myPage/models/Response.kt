package com.example.coupangeats.src.main.myPage.models


import com.google.gson.annotations.SerializedName

data class Response(
    @SerializedName("id")
    val id: String,
    @SerializedName("mobile")
    val mobile: String,
    @SerializedName("mobile_e164")
    val mobileE164: String,
    @SerializedName("name")
    val name: String
)