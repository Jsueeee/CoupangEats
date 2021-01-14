package com.example.coupangeats.src.main.menuInfo

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.src.main.menuInfo.models.CartRequest
import com.example.coupangeats.src.main.menuInfo.models.CartResponse
import com.example.coupangeats.src.main.menuInfo.models.MenuInfoResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuService(val view: MenuActivityView) {
    fun getMenuInfo(menuIdx: Int){
        val menuRetrofitInterface =
            ApplicationClass.sRetrofit.create(MenuRetrofitInterface::class.java)
        menuRetrofitInterface.getMenuInfo(menuIdx).enqueue(object : Callback<MenuInfoResult> {
            override fun onResponse(
                call: Call<MenuInfoResult>,
                response: Response<MenuInfoResult>
            ) {
                Log.d(TAG, "MenuService - onResponse() : ")
                view.onGetMenuInfoSuccess(response.body() as MenuInfoResult)
            }

            override fun onFailure(call: Call<MenuInfoResult>, t: Throwable) {
                view.onGetMenuInfoFailure(t.message ?: "통신오류")
            }

        })
    }

    fun postCartRequest(cartRequest: CartRequest){
        val menuRetrofitInterface =
            ApplicationClass.sRetrofit.create(MenuRetrofitInterface::class.java)
        menuRetrofitInterface.postCartRequest(cartRequest).enqueue(object : Callback<CartResponse> {
            override fun onResponse(call: Call<CartResponse>, response: Response<CartResponse>) {
                Log.d(TAG, "MenuService - onResponse() : 카트 담기 API 호출 성공 ${response.body()}")
                view.onPostCartRequestSuccess(response.body() as CartResponse)
            }

            override fun onFailure(call: Call<CartResponse>, t: Throwable) {
                Log.d(TAG, "MenuService - onFailure() : 카트 담기 API 호출 실패")
                view.onPostCartRequestFailure(t.message ?: "통신오류")
            }

        })
    }
}