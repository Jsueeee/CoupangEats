package com.example.coupangeats.src.main.order.retrofit

import com.example.coupangeats.src.main.order.models.OrderCancelRequest
import com.example.coupangeats.src.main.order.models.OrderListResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OrderRetrofitInterface {
    @GET("/order")
    fun getOrderList(
        @Query("category") category: Int
    ): Call<OrderListResponse>

    @POST("/order/cancellation")
    fun postOrderCancel(
        @Body params: OrderCancelRequest
    ): Call<JsonObject>
}