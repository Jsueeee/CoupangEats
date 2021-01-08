package com.example.coupangeats.src.main.address.map

import com.example.coupangeats.src.main.address.models.ReverseGeocodingResult
import com.example.coupangeats.src.main.address.models.SettingAddressResult

interface MapActivityView {
    fun onGetReverseGeocodingSuccess(response: ReverseGeocodingResult)
    fun onGetReverseGeocodingFailure(message: String)
}