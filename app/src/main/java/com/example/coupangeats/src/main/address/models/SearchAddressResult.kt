package com.example.coupangeats.src.main.address.models


import com.google.gson.annotations.SerializedName

data class SearchAddressResult(
    @SerializedName("documents")
    val documents: List<Document>,
    @SerializedName("meta")
    val meta: Meta
)