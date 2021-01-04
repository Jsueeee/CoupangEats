package com.example.coupangeats.src.main.home.models

data class Franchise(
    val coupon: String,
    val deliveryFee: String,
    val distance: String,
    val reviewCount: Int,
    val storeIdx: Int,
    val storeName: String,
    val storePhoto: String,
    val storeStar: Float
)