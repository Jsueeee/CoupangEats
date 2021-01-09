package com.example.coupangeats.src.main.address.mapSearch

import com.example.coupangeats.src.main.address.models.SearchAddressResult

interface MapSearchView {
    fun getSearchAddressSuccess(response: SearchAddressResult)
    fun getSearchAddressFailure(message: String)
}