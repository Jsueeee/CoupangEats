package com.example.coupangeats.src.main.address.mapSearch

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMapSearchBinding
import com.example.coupangeats.src.main.address.mapSearch.fragment.SearchAddressDefaultFragment
import com.example.coupangeats.src.main.address.mapSearch.fragment.SearchAddressKeywordFragment
import com.example.coupangeats.src.main.address.mapSearch.fragment.SearchAddressSettingFragment
import com.example.coupangeats.src.main.address.mapSearch.recyclerview.SearchAddressRecyclerviewAdapter
import com.example.coupangeats.src.main.address.models.SearchAddressResult
import com.example.coupangeats.src.main.address.models.SearchRecyclerViewResult

const val TAG = "LOG"

class MapSearchActivity : BaseActivity<ActivityMapSearchBinding>(ActivityMapSearchBinding::inflate),
    MapSearchView {
    private lateinit var searchTxt: String

    var searchResultItemList = ArrayList<SearchRecyclerViewResult>()


    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.etSearchAddress.setOnTouchListener { v, event ->
            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    val imm =
                        this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_map_detail, SearchAddressDefaultFragment())
                        .commitAllowingStateLoss()

                    binding.etSearchAddress.requestFocus()

                    imm.showSoftInput(binding.etSearchAddress, 0)

                    //엔터 누르면 주소검색
                    binding.etSearchAddress.setOnKeyListener { v, keyCode, event ->
                        if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                            //엔터 누르면 키보드 자동 내리기
                            imm.hideSoftInputFromWindow(binding.etSearchAddress.windowToken, 0)

                            searchTxt = binding.etSearchAddress.text.toString()
                            Log.d(TAG, "MapSearchActivity - onCreate() : 검색어 : $searchTxt")

                            MapSearchService(this).getSearchAddress(
                                searchTxt,
                                resources.getString(R.string.Kakao_Authorization)
                            )



                            true
                        } else false
                    }

                }
            }
            true
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_map_detail, SearchAddressSettingFragment())
            .commitAllowingStateLoss()


    }

    override fun getSearchAddressSuccess(response: SearchAddressResult) {
        response.documents.forEach {
            searchResultItemList.add(
                SearchRecyclerViewResult(
                    addressName = it.addressName,
                    roadAddressName = it.roadAddressName, placeName = it.placeName
                )
            )
        }
       // SearchAddressKeywordFragment(searchResultItemList)
        Log.d(TAG, "MapSearchActivity - getSearchAddressSuccess() : searchResultItemList $searchResultItemList")

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_map_detail, SearchAddressKeywordFragment(searchResultItemList))
            .commitAllowingStateLoss()

    }

    override fun getSearchAddressFailure(message: String) {

    }
}