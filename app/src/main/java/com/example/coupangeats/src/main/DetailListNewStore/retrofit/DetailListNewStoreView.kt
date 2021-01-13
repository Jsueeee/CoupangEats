package com.example.coupangeats.src.main.DetailListNewStore.retrofit

import com.example.coupangeats.src.main.DetailListNewStore.models.DetailListNewStoreResult
import com.example.coupangeats.src.main.detailListFranchise.models.DetailListResult

interface DetailListNewStoreView {
    fun onGetDetailNewStoreListSuccess(response: DetailListNewStoreResult)
    fun onGetDetailNewStoreListFailure(message: String)
}