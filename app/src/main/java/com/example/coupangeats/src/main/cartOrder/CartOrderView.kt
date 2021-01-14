package com.example.coupangeats.src.main.cartOrder

import com.example.coupangeats.src.main.cartOrder.models.CartOrderResponse

interface CartOrderView {
    fun onGetCartOrderResponseSuccess(response: CartOrderResponse)
    fun onGetCartOrderResponseFailure(message: String)
}