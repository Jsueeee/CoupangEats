package com.example.coupangeats.src.main.menuInfo.models


import com.google.gson.annotations.SerializedName

data class MenuInfoResult(
    @SerializedName("code")
    val code: Int,
    @SerializedName("isSuccess")
    val isSuccess: Boolean,
    @SerializedName("menuInfo")
    val menuInfo: List<MenuInfo>,
    @SerializedName("menuPhoto")
    val menuPhoto: List<String>,
    @SerializedName("message")
    val message: String,
    @SerializedName("optCategoryMenu")
    val optCategoryMenu: List<OptCategoryMenu>
)