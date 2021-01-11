package com.example.coupangeats.src.main.storeInfo

import com.example.coupangeats.src.main.storeInfo.models.StoreInfoResult

interface StoreActivityView {
    fun onGetStoreInfoSuccess(response: StoreInfoResult)
    fun onGetStoreInfoFailure(message: String)
}