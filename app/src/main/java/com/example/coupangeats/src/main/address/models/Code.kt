package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class Code(
    @SerializedName("id")
    val id: String,
    @SerializedName("mappingId")
    val mappingId: String,
    @SerializedName("type")
    val type: String
)