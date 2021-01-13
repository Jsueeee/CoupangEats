package com.example.coupangeats.src.main.detailListFranchise.retrofit

import com.example.coupangeats.src.main.detailListFranchise.models.DetailListResult

interface DetailFranchiseView {
    fun onGetDetailFranchiseListSuccess(response: DetailListResult)
    fun onGetDetailFranchiseListFailure(message: String)
}