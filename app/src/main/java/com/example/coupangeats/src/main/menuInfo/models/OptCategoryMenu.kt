package com.example.coupangeats.src.main.menuInfo.models


import com.google.gson.annotations.SerializedName

data class OptCategoryMenu(
    @SerializedName("optCategoryIdx")
    val optCategoryIdx: Int,
    @SerializedName("optCategoryName")
    val optCategoryName: String,
    @SerializedName("optmenuList")
    val optmenuList: List<Optmenu>,
    @SerializedName("isMandatory")
    val isMandatory: String,
    @SerializedName("maxSelect")
    val maxSelect: Int
)