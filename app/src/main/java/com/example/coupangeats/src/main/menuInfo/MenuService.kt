package com.example.coupangeats.src.main.menuInfo

import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.src.main.menuInfo.models.MenuInfoResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MenuService(val view: MenuActivityVeiw) {
    fun getMenuInfo(menuIdx: Int){
        val menuRetrofitInterface =
            ApplicationClass.sRetrofit.create(MenuRetrofitInterface::class.java)
        menuRetrofitInterface.getMenuInfo(menuIdx).enqueue(object : Callback<MenuInfoResult>{
            override fun onResponse(
                call: Call<MenuInfoResult>,
                response: Response<MenuInfoResult>
            ) {
                view.onGetMenuInfoSuccess(response.body() as MenuInfoResult)
            }

            override fun onFailure(call: Call<MenuInfoResult>, t: Throwable) {
                view.onGetMenuInfoFailure(t.message ?: "통신오류")
            }

        })
    }
}