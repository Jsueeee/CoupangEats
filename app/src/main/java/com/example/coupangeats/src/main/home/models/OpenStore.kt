package com.example.coupangeats.src.main.home.models

data class OpenStore(
    val coupon: Any,
    val deliveryFee: String,
    val distance: String,
    val storeIdx: Int,
    val storeName: String,
    val storePhoto: String
)