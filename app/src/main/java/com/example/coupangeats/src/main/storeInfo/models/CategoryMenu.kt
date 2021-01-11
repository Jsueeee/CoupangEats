package com.example.coupangeats.src.main.storeInfo.models


import com.google.gson.annotations.SerializedName

data class CategoryMenu(
    @SerializedName("categoryDetail")
    val categoryDetail: String?,
    @SerializedName("categoryIdx")
    val categoryIdx: Int,
    @SerializedName("categoryName")
    val categoryName: String,
    @SerializedName("menuList")
    val menuList: ArrayList<Menu>
)