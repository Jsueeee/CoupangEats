package com.example.coupangeats.src.main.menuInfo.models


import com.google.gson.annotations.SerializedName

data class Optmenu(
    @SerializedName("menuOptIdx")
    val menuOptIdx: Int,
    @SerializedName("menuOptName")
    val menuOptName: String,
    @SerializedName("menuOptPrice")
    val menuOptPrice: String?,
    @SerializedName("optPrice")
    val optPrice: Any?
)