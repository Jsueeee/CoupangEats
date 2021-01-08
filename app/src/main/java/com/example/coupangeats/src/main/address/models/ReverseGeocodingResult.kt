package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class ReverseGeocodingResult(
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("status")
    val status: Status
)