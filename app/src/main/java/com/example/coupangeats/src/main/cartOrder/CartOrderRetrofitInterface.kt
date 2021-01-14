package com.example.coupangeats.src.main.cartOrder

import com.example.coupangeats.src.main.cartOrder.models.CartOrderResponse
import com.example.coupangeats.src.main.cartOrder.models.order.OrderRequest
import com.example.coupangeats.src.main.cartOrder.models.order.OrderResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface CartOrderRetrofitInterface {
    @GET("/carts")
    fun getCartOrderResponse(): Call<CartOrderResponse>

    @POST("/order")
    fun postOrderRequest(
        @Body params: OrderRequest
    ): Call<OrderResponse>
}