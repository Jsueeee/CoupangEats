package com.example.coupangeats.src.main.cartOrder

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.cartOrder.models.CartOrderResponse
import com.example.coupangeats.src.main.cartOrder.models.order.OrderRequest
import com.example.coupangeats.src.main.cartOrder.models.order.OrderResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CartOrderService(val view: CartOrderView) {

    fun getCartOrderResponse(){
        val cartOrderRetrofitInterface =
            ApplicationClass.sRetrofit.create(CartOrderRetrofitInterface::class.java)
        cartOrderRetrofitInterface.getCartOrderResponse().enqueue(object :
            Callback<CartOrderResponse> {
            override fun onResponse(
                call: Call<CartOrderResponse>,
                response: Response<CartOrderResponse>
            ) {
                Log.d(TAG, "CartOrderService - onResponse() : 주문할 카트 조회 API 호출 성공 : ${response.body()}")
                view.onGetCartOrderResponseSuccess(response.body() as CartOrderResponse)
            }

            override fun onFailure(call: Call<CartOrderResponse>, t: Throwable) {
                view.onGetCartOrderResponseFailure(t.message ?: "통신오류")
            }

        })
    }
    fun postOrderRequest(orderRequest: OrderRequest){
        val cartOrderRetrofitInterface =
            ApplicationClass.sRetrofit.create(CartOrderRetrofitInterface::class.java)
        cartOrderRetrofitInterface.postOrderRequest(orderRequest).enqueue(object :
            Callback<OrderResponse> {
            override fun onResponse(call: Call<OrderResponse>, response: Response<OrderResponse>) {
                Log.d(TAG, "CartOrderService - onResponse() : 결제 주문 API 호출 성공 : ${response.body()}")
            }

            override fun onFailure(call: Call<OrderResponse>, t: Throwable) {
                Log.d(TAG, "CartOrderService - onFailure() : 주문 실패")
            }

        })
    }

}