package com.example.coupangeats.src.main.DetailListNewStore.retrofit

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.src.main.DetailListNewStore.models.DetailListNewStoreResult
import com.example.coupangeats.src.main.detailListFranchise.models.DetailListResult
import com.example.coupangeats.src.main.detailListFranchise.retrofit.DetailFranchiseRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailListNewStoreService(val view: DetailListNewStoreView) {
    fun getDetailFranchiseList(){
        val detailNewStoreRetrofitInterface =
            ApplicationClass.sRetrofit.create(DetailListNewStoreRetrofitInterface::class.java)
        detailNewStoreRetrofitInterface.getDetailNewStoreList().enqueue(object :
            Callback<DetailListNewStoreResult> {
            override fun onResponse(
                call: Call<DetailListNewStoreResult>,
                response: Response<DetailListNewStoreResult>
            ) {
                Log.d(ApplicationClass.TAG, "DetailListNewStoreService - onResponse() : 인기 new store 세부조회 api 호출 성공 : ${response.body()}")
                view.onGetDetailNewStoreListSuccess(response.body() as DetailListNewStoreResult)
            }

            override fun onFailure(call: Call<DetailListNewStoreResult>, t: Throwable) {
                view.onGetDetailNewStoreListFailure(t.message ?: "통신오류")
            }
        })
    }
}