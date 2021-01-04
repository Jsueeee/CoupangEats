package com.example.coupangeats.src.main.home

import com.example.coupangeats.src.main.home.models.HomeResultResponse

interface HomeFragmentView {

    fun onGetHomeResultSuccess(response: HomeResultResponse)
    fun onGetHomeResultFailure(message: String)
}