package com.example.coupangeats.src.main.home.models

import com.google.gson.annotations.SerializedName

data class ResultHome(
    @SerializedName("promotion") val promotion: ArrayList<ResultPromotion>,
    @SerializedName("category") val category: ArrayList<ResultCategory>,
    @SerializedName("franchise") val franchise: ArrayList<ResultFranchise>,
    @SerializedName("openStore") val result: ArrayList<ResultOpenStore>,
    @SerializedName("mainStore") val mainStore: ArrayList<ResultMainStore>
)
