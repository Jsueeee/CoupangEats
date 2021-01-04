package com.example.coupangeats.src.main.home.models

data class HomeResultResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Result
)