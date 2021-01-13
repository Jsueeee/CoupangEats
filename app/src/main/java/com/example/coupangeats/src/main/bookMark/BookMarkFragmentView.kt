package com.example.coupangeats.src.main.bookMark

import com.example.coupangeats.src.main.bookMark.models.MyBookMarkList

interface BookMarkFragmentView {
    fun onGetBookMarkListSuccess(response: MyBookMarkList)
    fun onGetBookMarkListFailure(message: String)

}