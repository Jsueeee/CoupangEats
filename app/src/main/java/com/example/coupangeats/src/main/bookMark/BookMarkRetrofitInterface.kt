package com.example.coupangeats.src.main.bookMark

import com.example.coupangeats.src.main.bookMark.models.MyBookMarkList
import retrofit2.Call
import retrofit2.http.GET

interface BookMarkRetrofitInterface {
    @GET("/hearts")
    fun getBookMarkList(): Call<MyBookMarkList>
}