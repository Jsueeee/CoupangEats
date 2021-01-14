package com.example.coupangeats.src.main.menuInfo

import com.example.coupangeats.src.main.menuInfo.models.CartResponse
import com.example.coupangeats.src.main.menuInfo.models.MenuInfoResult

interface MenuActivityView {
    fun onGetMenuInfoSuccess(response: MenuInfoResult)
    fun onGetMenuInfoFailure(message: String)
    fun onPostCartRequestSuccess(response: CartResponse)
    fun onPostCartRequestFailure(message: String)
}