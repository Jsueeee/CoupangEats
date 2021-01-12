package com.example.coupangeats.src.main.myPage

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.src.main.myPage.models.NaverUserInfoResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageService(val view: MyPageFragment) {
    fun getUserInfo(NaverAccessToken: String) {
        val myPageRetrofitInterface =
            ApplicationClass.naverUserRetrofit.create(MyPageRetrofitInterface::class.java)
        myPageRetrofitInterface.getUserInfo("Bearer $NaverAccessToken").enqueue(object :
            Callback<NaverUserInfoResult> {
            override fun onResponse(
                call: Call<NaverUserInfoResult>,
                response: Response<NaverUserInfoResult>
            ) {
                if (response.body() == null) {
                    Log.d(TAG, "MyPageService - onResponse() : null")
                }
                else{
                    view.onGetNaverUserInfoSuccess(response.body() as NaverUserInfoResult)
                }

            }

            override fun onFailure(call: Call<NaverUserInfoResult>, t: Throwable) {
                view.onGetNaverUserInfoFailure(t.message ?: "통신오류")
            }

        })
    }
}