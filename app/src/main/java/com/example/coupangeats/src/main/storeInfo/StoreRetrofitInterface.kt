package com.example.coupangeats.src.main.storeInfo

import com.example.coupangeats.src.main.storeInfo.models.HeartStoreResult
import com.example.coupangeats.src.main.storeInfo.models.StoreInfoResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface StoreRetrofitInterface {
    @GET("/stores/{storeIdx}")
    fun getStoreInfo(
        @Path("storeIdx") storeIdx: Int
    ): Call<StoreInfoResult>

    @POST("/stores/hart")
    fun postStoreHeart(
        @Body storeIdx: Int
    ): Call<HeartStoreResult>
}