package com.example.coupangeats.src.main.myPage.coupon.retrofit

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.myPage.coupon.models.CouponViewResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CouponService(val view: CouponView) {
    fun getCouponResult(){
        val couponRetrofitInterface =
            ApplicationClass.sRetrofit.create(CouponRetrofitInterface::class.java)
        couponRetrofitInterface.getCouponResult().enqueue(object : Callback<CouponViewResult> {
            override fun onResponse(
                call: Call<CouponViewResult>,
                response: Response<CouponViewResult>
            ) {
                Log.d(TAG, "CouponService - onResponse() : 쿠폰리스트 조회 API 호출 성공 ${response.body()}")
                view.onGetCouponResultSuccess(response.body() as CouponViewResult)
            }

            override fun onFailure(call: Call<CouponViewResult>, t: Throwable) {
                view.onGetCouponResultFailure(t.message ?: "통신오류")
            }

        })
    }
}