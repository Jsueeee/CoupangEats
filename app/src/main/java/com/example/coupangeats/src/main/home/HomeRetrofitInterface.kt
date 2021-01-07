package com.example.coupangeats.src.main.home

import com.example.coupangeats.src.main.home.models.HomeResultResponse
import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.home.models.postSignUpRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface HomeRetrofitInterface {
    @GET("home")
    fun getHomeResult() : Call<HomeResultResponse>

    @POST("/kakao-login")
    fun postAccessToken(@Body params: postSignUpRequest) : Call<SignUpResponse>
}