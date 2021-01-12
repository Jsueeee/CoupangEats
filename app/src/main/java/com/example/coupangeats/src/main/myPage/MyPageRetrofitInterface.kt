package com.example.coupangeats.src.main.myPage

import com.example.coupangeats.src.main.myPage.models.NaverUserInfoResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface MyPageRetrofitInterface {
    @GET("nid/me")
    fun getUserInfo(
        @Header("Authorization") Authorization: String
    ): Call<NaverUserInfoResult>
}