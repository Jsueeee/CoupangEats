package com.example.coupangeats.src.main.home

import com.example.coupangeats.src.main.home.models.HomeResultResponse
import com.example.coupangeats.src.main.home.models.SignUpResponse

interface HomeFragmentView {

    fun onGetHomeResultSuccess(response: HomeResultResponse)
    fun onGetHomeResultFailure(message: String)
    fun onPostSignUpSuccess(response: SignUpResponse)
    fun onPostSignUpFailure(message: String)
}