package com.example.coupangeats.src.main.DetailListNewStore.models


import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("coupon")
    val coupon: Any?,
    @SerializedName("deliveryFee")
    val deliveryFee: String,
    @SerializedName("deliveryTime")
    val deliveryTime: String,
    @SerializedName("distance")
    val distance: String,
    @SerializedName("img")
    val img: List<String>,
    @SerializedName("isCheetah")
    val isCheetah: String,
    @SerializedName("isnewStore")
    val isnewStore: String,
    @SerializedName("reviewCount")
    val reviewCount: Int,
    @SerializedName("storeIdx")
    val storeIdx: Int,
    @SerializedName("storeName")
    val storeName: String,
    @SerializedName("storeStar")
    val storeStar: Any?
)