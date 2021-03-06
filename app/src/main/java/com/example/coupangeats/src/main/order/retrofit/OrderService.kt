package com.example.coupangeats.src.main.order.retrofit

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.order.models.OrderCancelRequest
import com.example.coupangeats.src.main.order.models.OrderListResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderService(val view: OrderFragmentView) {
    fun onGetOrderList(category: Int){
        val orderRetrofitInterface =
            ApplicationClass.sRetrofit.create(OrderRetrofitInterface::class.java)
        orderRetrofitInterface.getOrderList(category).enqueue(object : Callback<OrderListResponse> {
            override fun onResponse(
                call: Call<OrderListResponse>,
                response: Response<OrderListResponse>
            ) {
                Log.d(TAG, "OrderService - onResponse() : 주문목록조회 API 호출 성공 ${response.body()}")
                view.onGetOrderListSuccess(response.body() as OrderListResponse)
            }

            override fun onFailure(call: Call<OrderListResponse>, t: Throwable) {
                view.onGetOrderListFailure(t.message ?: "통신오류")
            }

        })
    }

    fun onPostOrderCancel(orderCancelRequest: OrderCancelRequest){
        val orderRetrofitInterface =
            ApplicationClass.sRetrofit.create(OrderRetrofitInterface::class.java)
        orderRetrofitInterface.postOrderCancel(orderCancelRequest).enqueue(object :
            Callback<JsonObject> {
            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                Log.d(TAG, "OrderService - onResponse() : 주문 취소 API 호출 성공 ${response.body()}")
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.d(TAG, "OrderService - onFailure() : 주문 취소 API 호출 실패 ${t.message}")
            }

        })
    }
}