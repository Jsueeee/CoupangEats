package com.example.coupangeats.src.main.cartOrder.models


import com.google.gson.annotations.SerializedName

data class CartOrderResponse(
    @SerializedName("cartList")
    val cartList: List<Cart>,
    @SerializedName("code")
    val code: Int,
    @SerializedName("coupon")
    val coupon: Coupon,
    @SerializedName("deliveryaddress")
    val deliveryaddress: List<Deliveryaddres>,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("minOrderCost")
    val minOrderCost: Any?,
    @SerializedName("payPrice")
    val payPrice: PayPrice,
    @SerializedName("payment")
    val payment: Payment,
    @SerializedName("storeIdx")
    val storeIdx: Int,
    @SerializedName("storeName")
    val storeName: String
)