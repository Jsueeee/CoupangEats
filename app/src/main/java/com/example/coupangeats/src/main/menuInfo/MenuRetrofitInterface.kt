package com.example.coupangeats.src.main.menuInfo

import com.example.coupangeats.src.main.menuInfo.models.CartRequest
import com.example.coupangeats.src.main.menuInfo.models.CartResponse
import com.example.coupangeats.src.main.menuInfo.models.MenuInfoResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MenuRetrofitInterface {
    @GET("/menus/{menuIdx}")
    fun getMenuInfo(
        @Path("menuIdx") menuIdx: Int
    ): Call<MenuInfoResult>

    @POST("/carts")
    fun postCartRequest(
        @Body params: CartRequest
    ): Call<CartResponse>
}