package com.example.coupangeats.src.main.storeInfo

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.home.HomeRetrofitInterface
import com.example.coupangeats.src.main.storeInfo.models.StoreInfoResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreService(val view: StoreActivityView) {
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
}