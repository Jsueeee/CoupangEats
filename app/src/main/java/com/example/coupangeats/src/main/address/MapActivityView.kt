package com.example.coupangeats.src.main.address

import com.example.coupangeats.src.main.address.models.ReverseGeocodingResult

interface MapActivityView {
    fun onGetReverseGeocodingSuccess(response: ReverseGeocodingResult)
    fun onGetReverseGeocodingFailure(message: String)
}