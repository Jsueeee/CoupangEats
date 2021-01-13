package com.example.coupangeats.src.main.storeInfo

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.home.HomeRetrofitInterface
import com.example.coupangeats.src.main.storeInfo.models.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreService(val view: StoreActivityView) {

    fun postStoreCoupon(storeIdx: Int, couponIdx: CouponIdx){
        val storeRetrofitInterface =
            ApplicationClass.sRetrofit.create(StoreRetrofitInterface::class.java)
        storeRetrofitInterface.postStoreCoupon(storeIdx, couponIdx).enqueue(object :
            Callback<CouponDownResult> {
            override fun onResponse(
                call: Call<CouponDownResult>,
                response: Response<CouponDownResult>
            ) {
                Log.d(
                    TAG,
                    "StoreService - onResponse() : 쿠폰 다운로드 요청 API 호출 성공 : ${response.body()}"
                )
                view.onPostStoreCouponSuccess(response.body() as CouponDownResult)
            }

            override fun onFailure(call: Call<CouponDownResult>, t: Throwable) {
                Log.d(TAG, "StoreService - onFailure() : 쿠폰 다운로드 요청 API 호출 실패")
                view.onPostStoreCouponFailure(t.message ?: "통신오류")
            }

        })
    }

    fun getStoreInfo(storeIdx: Int){
        val storeRetrofitInterface =
            ApplicationClass.sRetrofit.create(StoreRetrofitInterface::class.java)
        storeRetrofitInterface.getStoreInfo(storeIdx).enqueue(object :
            Callback<StoreInfoResult> {
            override fun onResponse(
                call: Call<StoreInfoResult>,
                response: Response<StoreInfoResult>
            ) {
                Log.d(TAG, "StoreService - onResponse() : 스토어 api 호출 성공 ${response.body()}")
                view.onGetStoreInfoSuccess(response.body() as StoreInfoResult)
            }

            override fun onFailure(call: Call<StoreInfoResult>, t: Throwable) {
                Log.d(TAG, "StoreService - onFailure() : 스토어 api 호출 실패 ${t.message}")
                view.onGetStoreInfoFailure(t.message ?: "통신오류")
            }

        })
    }

    fun postStoreHeart(storeIdx: StoreIdx){
        Log.d(TAG, "StoreService - postStoreHeart() : storeIdx : $storeIdx")
        val storeRetrofitInterface = ApplicationClass.sRetrofit.create(StoreRetrofitInterface::class.java)
        storeRetrofitInterface.postStoreHeart(storeIdx).enqueue(object :
            Callback<HeartStoreResult> {
            override fun onResponse(
                call: Call<HeartStoreResult>,
                response: Response<HeartStoreResult>
            ) {
                Log.d(TAG, "StoreService - onResponse() : 즐겨찾기 api 호출 성공 ${response.body()}")
                view.onPostHeartSuccess(response.body() as HeartStoreResult)
            }

            override fun onFailure(call: Call<HeartStoreResult>, t: Throwable) {
                view.onPostHeartFailure(t.message ?: "통신오류")
            }

        })
    }
}