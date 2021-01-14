package com.example.coupangeats.src.main.menuInfo.models

data class CartRequest(
    val storeIdx: Int,
    val menuIdx: Int,
    val quantity: Int,
    val optionList: ArrayList<Int>
)
