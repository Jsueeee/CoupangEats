package com.example.coupangeats.src.main.bookMark

import android.util.Log
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.src.main.bookMark.models.MyBookMarkList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BookMarkService(val view: BookMarkFragmentView) {
    fun getBookMarkList(){
        val bookMarkRetrofitInterface =
            ApplicationClass.sRetrofit.create(BookMarkRetrofitInterface::class.java)
        bookMarkRetrofitInterface.getBookMarkList().enqueue(object :
            Callback<MyBookMarkList> {
            override fun onResponse(
                call: Call<MyBookMarkList>,
                response: Response<MyBookMarkList>
            ) {
                Log.d(TAG, "BookMarkService - onResponse() : 북마크 리스트 조회 API 호출 성공 ${response.body()}")
                view.onGetBookMarkListSuccess(response.body() as MyBookMarkList)
            }

            override fun onFailure(call: Call<MyBookMarkList>, t: Throwable) {
                view.onGetBookMarkListFailure(t.message ?: "통신오류")
            }
        })
    }
}