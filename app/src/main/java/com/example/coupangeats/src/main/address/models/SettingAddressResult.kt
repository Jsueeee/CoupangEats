package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class SettingAddressResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String
)