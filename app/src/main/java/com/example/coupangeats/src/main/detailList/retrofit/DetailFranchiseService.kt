package com.example.coupangeats.src.main.detailList.retrofit

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.detailList.models.DetailListResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailFranchiseService(val view: DetailFranchiseView) {
    fun getDetailFranchiseList(){
        val detailFranchiseRetrofitInterface =
            ApplicationClass.sRetrofit.create(DetailFranchiseRetrofitInterface::class.java)
        detailFranchiseRetrofitInterface.getDetailFranchiseList().enqueue(object :
            Callback<DetailListResult> {
            override fun onResponse(
                call: Call<DetailListResult>,
                response: Response<DetailListResult>
            ) {
                Log.d(TAG, "DetailFranchiseService - onResponse() : 인기 프랜차이즈 세부조회 api 호출 성공 : ${response.body()}")
                view.onGetDetailFranchiseListSuccess(response.body() as DetailListResult)
            }

            override fun onFailure(call: Call<DetailListResult>, t: Throwable) {
                view.onGetDetailFranchiseListFailure(t.message ?: "통신오류")
            }
        })
    }
}