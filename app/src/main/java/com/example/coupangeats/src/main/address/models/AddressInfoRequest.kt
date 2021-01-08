package com.example.coupangeats.src.main.address.models

import java.text.DecimalFormat
import java.time.format.DecimalStyle

data class AddressInfoRequest(
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val buildingName: String,
    val addressDetail: String
)