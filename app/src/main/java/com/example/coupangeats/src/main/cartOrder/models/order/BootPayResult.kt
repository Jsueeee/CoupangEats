package com.example.coupangeats.src.main.cartOrder.models.order


import com.google.gson.annotations.SerializedName

data class BootPayResult(
    @SerializedName("action")
    val action: String,
    @SerializedName("card_code")
    val cardCode: String,
    @SerializedName("card_name")
    val cardName: String,
    @SerializedName("card_no")
    val cardNo: String,
    @SerializedName("card_quota")
    val cardQuota: String,
    @SerializedName("item_name")
    val itemName: String,
    @SerializedName("method")
    val method: String,
    @SerializedName("method_name")
    val methodName: String,
    @SerializedName("order_id")
    val orderId: String,
    @SerializedName("payment_group")
    val paymentGroup: String,
    @SerializedName("payment_group_name")
    val paymentGroupName: String,
    @SerializedName("payment_name")
    val paymentName: String,
    @SerializedName("pg")
    val pg: String,
    @SerializedName("pg_name")
    val pgName: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("purchased_at")
    val purchasedAt: String,
    @SerializedName("receipt_id")
    val receiptId: String,
    @SerializedName("receipt_url")
    val receiptUrl: String,
    @SerializedName("requested_at")
    val requestedAt: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("tax_free")
    val taxFree: Int,
    @SerializedName("url")
    val url: String
)