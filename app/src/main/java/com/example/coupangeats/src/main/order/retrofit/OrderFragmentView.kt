package com.example.coupangeats.src.main.order.retrofit

import com.example.coupangeats.src.main.order.models.OrderListResponse

interface OrderFragmentView {
    fun onGetOrderListSuccess(response: OrderListResponse)
    fun onGetOrderListFailure(message: String)
}