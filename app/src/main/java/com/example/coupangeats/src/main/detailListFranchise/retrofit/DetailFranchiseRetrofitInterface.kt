package com.example.coupangeats.src.main.detailListFranchise.retrofit

import com.example.coupangeats.src.main.detailListFranchise.models.DetailListResult
import retrofit2.Call
import retrofit2.http.GET

interface DetailFranchiseRetrofitInterface {
    @GET("/franchise-stores")
    fun getDetailFranchiseList(): Call<DetailListResult>
}