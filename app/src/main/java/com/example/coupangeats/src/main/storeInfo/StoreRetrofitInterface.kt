package com.example.coupangeats.src.main.storeInfo

import com.example.coupangeats.src.main.storeInfo.models.*
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

    @POST("/stores/heart")
    fun postStoreHeart(
        @Body params: StoreIdx
    ): Call<HeartStoreResult>

    @POST("/stores/{storeIdx}/coupon")
    fun postStoreCoupon(
        @Path("storeIdx") storeIdx: Int,
        @Body params: CouponIdx
    ): Call<CouponDownResult>
}