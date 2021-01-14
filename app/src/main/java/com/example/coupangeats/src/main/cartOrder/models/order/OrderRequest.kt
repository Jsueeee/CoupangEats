package com.example.coupangeats.src.main.cartOrder.models.order

data class OrderRequest (
    val toStore: String?,
    val noPlastic: String?,
    val deliveryReqIdx: Int?,
    val receiptId: String
)