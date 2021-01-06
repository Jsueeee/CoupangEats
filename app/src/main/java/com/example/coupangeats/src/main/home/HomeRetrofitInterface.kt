package com.example.coupangeats.src.main.home

import com.example.coupangeats.src.main.home.models.HomeResultResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeRetrofitInterface {
    @GET("home")
    fun getHomeResult() : Call<HomeResultResponse>
}