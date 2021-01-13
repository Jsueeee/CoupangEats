package com.example.coupangeats.src.main.menuInfo

import com.example.coupangeats.src.main.home.models.SignUpResponse
import com.example.coupangeats.src.main.menuInfo.models.MenuInfoResult

interface MenuActivityView {
    fun onGetMenuInfoSuccess(response: MenuInfoResult)
    fun onGetMenuInfoFailure(message: String)
}