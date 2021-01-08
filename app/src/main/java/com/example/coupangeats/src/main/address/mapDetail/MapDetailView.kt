package com.example.coupangeats.src.main.address.mapDetail

import com.example.coupangeats.src.main.address.models.SettingAddressResult

interface MapDetailView {
    fun onPatchAddressInfoRequestSuccess(response: SettingAddressResult)
    fun onPatchAddressInfoRequestFailure(message: String)
}