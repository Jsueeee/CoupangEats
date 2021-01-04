package com.example.coupangeats.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultPromotion(
    @SerializedName("promotionIdx") val promotionIdx: Int,
    @SerializedName("title") val title: String,
    @SerializedName("promotionPhoto") val promotionPhoto: String
)
