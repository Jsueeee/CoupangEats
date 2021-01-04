package com.example.coupangeats.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultCategory(
    @SerializedName("storeCatIdx") val storeCatIdx: Int,
    @SerializedName("storeCatName") val storeCatName: String,
)
