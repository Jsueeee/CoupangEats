package com.example.coupangeats.src.main.home

import android.content.SharedPreferences
import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.coupangeats.config.ApplicationClass.Companion.sSharedPreferences
import com.example.coupangeats.src.main.home.models.HomeResultResponse
import com.example.coupangeats.src.main.home.models.PostSignUpRequest
import com.example.coupangeats.src.main.home.models.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeService(val view: HomeFragmentView) {

    fun getHomeResult() {
        val homeRetrofitInterface =
            ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.getHomeResult(X_ACCESS_TOKEN).enqueue(object :
            Callback<HomeResultResponse> {
            override fun onResponse(
                call: Call<HomeResultResponse>,
                response: Response<HomeResultResponse>
            ) {
                Log.d(TAG, "HomeService - onResponse() : API 호출 성공")
                Log.d(TAG, "HomeService - onResponse() : ${response.body()}")
                if (response.body() == null) {
                    Log.d(TAG, "HomeService - onResponse() : 홈화면 조회 결과 null")
                }else{
                    view.onGetHomeResultSuccess(response.body() as HomeResultResponse)
                }
            }

            override fun onFailure(call: Call<HomeResultResponse>, t: Throwable) {
                Log.d(TAG, "HomeService - onFailure() : API 호출 실패 - ${t.message}")
                view.onGetHomeResultFailure(t.message ?: "통신오류")
            }

        })
    }

    fun tryPostSignUpKaKao(postSignUpRequest: PostSignUpRequest) {
        val homeRetrofitInterface =
            ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postKaKaoAccessToken(postSignUpRequest)
            .enqueue(object : Callback<SignUpResponse> {
                override fun onResponse(
                    call: Call<SignUpResponse>,
                    response: Response<SignUpResponse>
                ) {
                    view.onPostSignUpSuccess(response.body() as SignUpResponse)
                  //  X_ACCESS_TOKEN = response.body()!!.result.jwt

                    val editor : SharedPreferences.Editor = sSharedPreferences.edit()
                    editor.putString("X_ACCESS_TOKEN", response.body()!!.result.jwt)
                    editor.apply()

                    Log.d(TAG, "HomeService - onResponse() : X_ACCESS_TOKEN : ${sSharedPreferences.getString("X_ACCESS_TOKEN", "")}")
                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    view.onPostSignUpFailure(t.message ?: "통신 오류")
                }

            })
    }

    fun tryPostSignUpNaver(postSignUpRequest: PostSignUpRequest) {
        val homeRetrofitInterface =
            ApplicationClass.sRetrofit.create(HomeRetrofitInterface::class.java)
        homeRetrofitInterface.postNaverAcccessToken(postSignUpRequest)
            .enqueue(object : Callback<SignUpResponse> {
                override fun onResponse(
                    call: Call<SignUpResponse>,
                    response: Response<SignUpResponse>
                ) {
                    view.onPostSignUpSuccess(response.body() as SignUpResponse)

                    val editor : SharedPreferences.Editor = sSharedPreferences.edit()
                    editor.putString("X_ACCESS_TOKEN", response.body()!!.result.jwt)
                    editor.apply()

                }

                override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                    view.onPostSignUpFailure(t.message ?: "통신 오류")
                }

            })
    }
}