package com.example.coupangeats.src.main.address

import com.example.coupangeats.src.main.address.models.AddressInfoRequest
import com.example.coupangeats.src.main.address.models.ReverseGeocodingResult
import com.example.coupangeats.src.main.address.models.SearchAddressResult
import com.example.coupangeats.src.main.address.models.SettingAddressResult
import retrofit2.Call
import retrofit2.http.*

interface MapRetrofitInterface {
    @GET("/map-reversegeocode/v2/gc")
    fun getReverseGeocoding(
        @Header("X-NCP-APIGW-API-KEY-ID") id: String,
        @Header("X-NCP-APIGW-API-KEY") secret: String,
        @Query("coords") coords: String,
        @Query("orders") orders: String,
        @Query("output") output: String,
    ): Call<ReverseGeocodingResult>

    @PATCH("/address")
    fun patchAddressInfo(
//        @Header("X-ACCESS-TOKEN") jwt: String,
        @Body params: AddressInfoRequest
    ): Call<SettingAddressResult>

    @GET("keyword.json")
    fun getSearchAddress(
        @Header("Authorization") Authorization: String,
        @Query("query") query: String
    ): Call<SearchAddressResult>
}