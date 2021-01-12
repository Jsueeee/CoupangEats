package com.example.coupangeats.src.main.storeInfo

import com.example.coupangeats.src.main.storeInfo.models.HeartStoreResult
import com.example.coupangeats.src.main.storeInfo.models.StoreInfoResult

interface StoreActivityView {
    fun onGetStoreInfoSuccess(response: StoreInfoResult)
    fun onGetStoreInfoFailure(message: String)
    fun onPostHeartSuccess(response: HeartStoreResult)
    fun onPostHeartFailure(message: String)

}