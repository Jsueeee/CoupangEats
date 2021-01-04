package com.example.coupangeats.src.main.home

import android.app.Application
import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.home.models.HomeResponse
import com.example.coupangeats.src.main.home.models.HomeResultResponse
import com.example.coupangeats.src.main.home.models.ResultHome
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class HomeService(val view: HomeFragmentView) {

    fun getHomeResult(){
        val homeRetrofitInterface = ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getHomeResult().enqueue(object : Callback<HomeResultResponse> {
            override fun onResponse(
                call: Call<HomeResultResponse>,
                response: Response<HomeResultResponse>
            ) {
                Log.d(TAG, "HomeService - onResponse() : API 호출 성공")
                Log.d(TAG, "HomeService - onResponse() : ${response.body()}")
                view.onGetHomeResultSuccess(response.body() as HomeResultResponse)
            }

            override fun onFailure(call: Call<HomeResultResponse>, t: Throwable) {
                Log.d(TAG, "HomeService - onFailure() : API 호출 실패 - ${t.message}")
                view.onGetHomeResultFailure(t.message ?: "통신오류")
            }

        })
    }
}