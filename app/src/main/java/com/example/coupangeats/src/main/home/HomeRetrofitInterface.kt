package com.example.coupangeats.src.main.home

import com.example.coupangeats.src.main.home.models.HomeResultResponse
import com.example.coupangeats.src.main.home.models.PostSignUpRequest
import com.example.coupangeats.src.main.home.models.SignUpResponse
import retrofit2.Call
import retrofit2.http.*

interface HomeRetrofitInterface {
    @GET("home")
    fun getHomeResult(
        @Header("X-ACCESS-TOKEN") jwt: String
    ) : Call<HomeResultResponse>

    @POST("/kakao-login")
    fun postKaKaoAccessToken(@Body params: PostSignUpRequest): Call<SignUpResponse>

    @POST("/naver-login")
    fun postNaverAcccessToken(@Body params: PostSignUpRequest): Call<SignUpResponse>
}