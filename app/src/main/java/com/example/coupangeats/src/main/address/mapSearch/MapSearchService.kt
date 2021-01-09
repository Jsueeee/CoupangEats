package com.example.coupangeats.src.main.address.mapSearch

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.address.MapRetrofitInterface
import com.example.coupangeats.src.main.address.models.SearchAddressResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapSearchService(val view: MapSearchView) {

    fun getSearchAddress(query: String, Kakao_Authorization: String){
        Log.d(TAG, "MapSearchService - onResponse() : api 키 : ${Kakao_Authorization}")
        Log.d(TAG, "MapSearchService - onResponse() : query : ${query}")

        val searchRetrofitInterface = ApplicationClass.kakaoRetrofit.create(MapRetrofitInterface::class.java)
        searchRetrofitInterface.getSearchAddress(Kakao_Authorization, query).enqueue(
            object :
                Callback<SearchAddressResult> {
                override fun onResponse(
                    call: Call<SearchAddressResult>,
                    response: Response<SearchAddressResult>
                ) {
                    Log.d(TAG, "MapSearchService - onResponse() : 주소검색 성공 ${response.body()}")
                    view.getSearchAddressSuccess(response.body() as SearchAddressResult)

                }

                override fun onFailure(call: Call<SearchAddressResult>, t: Throwable) {
                    Log.d(TAG, "MapSearchService - onFailure() : 주소검색 실패 ${t.message}")
                    view.getSearchAddressFailure(t.message ?: "통신오류")
                }

            })
    }
}