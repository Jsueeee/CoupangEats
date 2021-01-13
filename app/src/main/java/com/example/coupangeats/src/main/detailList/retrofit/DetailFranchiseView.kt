package com.example.coupangeats.src.main.detailList.retrofit

import com.example.coupangeats.src.main.detailList.models.DetailListResult
import com.example.coupangeats.src.main.home.models.MainStore

interface DetailFranchiseView {
    fun onGetDetailFranchiseListSuccess(response: DetailListResult)
    fun onGetDetailFranchiseListFailure(message: String)
}