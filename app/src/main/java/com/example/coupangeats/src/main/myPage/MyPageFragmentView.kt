package com.example.coupangeats.src.main.myPage

import com.example.coupangeats.src.main.myPage.models.NaverUserInfoResult

interface MyPageFragmentView {
    fun onGetNaverUserInfoSuccess(response: NaverUserInfoResult)
    fun onGetNaverUserInfoFailure(message: String)
}