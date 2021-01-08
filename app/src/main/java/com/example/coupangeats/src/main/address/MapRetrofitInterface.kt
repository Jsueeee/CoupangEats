package com.example.coupangeats.src.main.address

import com.example.coupangeats.src.main.address.models.ReverseGeocodingResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface MapRetrofitInterface {
    @GET("/map-reversegeocode/v2/gc")
    fun getReverseGeocoding(
        @Header("X-NCP-APIGW-API-KEY-ID") id: String,
        @Header("X-NCP-APIGW-API-KEY") secret: String,
        @Query("coords") coords: String,
        @Query("orders") orders: String,
        @Query("output") output: String,
    ): Call<ReverseGeocodingResult>
}