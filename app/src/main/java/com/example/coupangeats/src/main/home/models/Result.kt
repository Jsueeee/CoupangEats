package com.example.coupangeats.src.main.home.models

data class Result(
    val category: List<Category>,
    val franchise: List<Franchise>,
    val mainStore: List<MainStore>,
    val openStore: List<OpenStore>,
    val promotion: List<Promotion>
)