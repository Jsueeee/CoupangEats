package com.example.coupangeats.src.main.home

import com.example.coupangeats.src.main.home.models.HomeResponse
import com.example.coupangeats.src.main.home.models.HomeResultResponse
import com.example.coupangeats.src.main.home.models.ResultHome
import retrofit2.Call
import retrofit2.http.GET

interface HomeRetrofitInterface {
    @GET("stores")
    fun getHomeResult() : Call<HomeResultResponse>
}