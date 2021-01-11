package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class PhotoReview(
    @SerializedName("content")
    val content: String,
    @SerializedName("reviewIdx")
    val reviewIdx: Int,
    @SerializedName("reviewPhoto")
    val reviewPhoto: String,
    @SerializedName("reviewStar")
    val reviewStar: Int
)