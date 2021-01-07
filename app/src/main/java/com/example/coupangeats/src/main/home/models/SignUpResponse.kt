package com.example.coupangeats.src.main.home.models

data class SignUpResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: SignUpResult
)