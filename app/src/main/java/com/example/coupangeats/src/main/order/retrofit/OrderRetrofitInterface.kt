package com.example.coupangeats.src.main.order.retrofit

import com.example.coupangeats.src.main.order.models.OrderListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OrderRetrofitInterface {
    @GET("/order")
    fun getOrderList(
        @Query("category") category: Int
    ): Call<OrderListResponse>
}