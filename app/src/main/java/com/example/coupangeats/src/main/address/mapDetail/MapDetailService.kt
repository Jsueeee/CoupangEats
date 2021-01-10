package com.example.coupangeats.src.main.address.mapDetail

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.coupangeats.src.main.address.MapRetrofitInterface
import com.example.coupangeats.src.main.address.models.AddressInfoRequest
import com.example.coupangeats.src.main.address.models.SettingAddressResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MapDetailService(val view: MapDetailView) {
    fun patchAddressInfoRequest(addressInfoRequest: AddressInfoRequest){
        val mapRetrofitInterface = ApplicationClass.sRetrofit.create(MapRetrofitInterface::class.java)

        mapRetrofitInterface.patchAddressInfo(addressInfoRequest).enqueue(object :
            Callback<SettingAddressResult> {
            override fun onResponse(
                call: Call<SettingAddressResult>,
                response: Response<SettingAddressResult>
            ) {
                Log.d(TAG, "MapService - onResponse() : 주소 저장 성공 ${response.body()}")
                view.onPatchAddressInfoRequestSuccess(response.body() as SettingAddressResult)
            }

            override fun onFailure(call: Call<SettingAddressResult>, t: Throwable) {
                Log.d(TAG, "MapService - onFailure() : 주소 저장 실패 ${t.message}")
                view.onPatchAddressInfoRequestFailure(t.message ?: "통신오류")
            }

        })
    }
}