package com.example.coupangeats.src.main.address.map

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.src.main.address.MapRetrofitInterface
import com.example.coupangeats.src.main.address.models.ReverseGeocodingResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapService(val view: MapActivityView) {

    fun getReverseGeocodingResult(coords: String){
        val mapRetrofitInterface = ApplicationClass.naverRetrofit.create(MapRetrofitInterface::class.java)

        Log.d(TAG, "MapService - getReverseGeocodingResult() : 위경도 : $coords")

        mapRetrofitInterface.getReverseGeocoding("h3b5sixohz", "r8gKqedhdsvXD33eoEVkrp1GSJSHuvaRWh7F5A82", coords, "roadaddr", "json").enqueue(object :
            Callback<ReverseGeocodingResult> {
            override fun onResponse(
                call: Call<ReverseGeocodingResult>,
                response: Response<ReverseGeocodingResult>
            ) {
                Log.d(TAG, "MapService - onResponse() : 주소 변환 API 호출 성공 ${response.body()}")
                view.onGetReverseGeocodingSuccess(response.body() as ReverseGeocodingResult)
            }

            override fun onFailure(call: Call<ReverseGeocodingResult>, t: Throwable) {
                Log.d(TAG, "MapService - onResponse() : 주소 변환 API 호출 실패 ${t.message}")
                view.onGetReverseGeocodingFailure(t.message ?: "통신오류")
            }

        })
    }

}