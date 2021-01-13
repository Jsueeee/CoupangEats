package com.example.coupangeats.src.main.detailList.retrofit

import com.example.coupangeats.src.main.detailList.models.DetailListResult
import retrofit2.Call
import retrofit2.http.GET

interface DetailFranchiseRetrofitInterface {
    @GET("/franchise-stores")
    fun getDetailFranchiseList(): Call<DetailListResult>
}