package com.example.coupangeats.src.main.DetailListNewStore.retrofit

import com.example.coupangeats.src.main.DetailListNewStore.models.DetailListNewStoreResult
import com.example.coupangeats.src.main.detailListFranchise.models.DetailListResult
import retrofit2.Call
import retrofit2.http.GET

interface DetailListNewStoreRetrofitInterface {
    @GET("/new-stores")
    fun getDetailNewStoreList(): Call<DetailListNewStoreResult>
}