package com.example.coupangeats.src.main.home.models

data class MainStore(
    val coupon: Any,
    val deliveryFee: String,
    val deliveryTime: String,
    val distance: String,
    val img_arr: List<String>,
    val reviewCount: Int,
    val storeIdx: Int,
    val storeName: String,
    val storeStar: Float
)