package com.example.coupangeats.src.main.address.mapSearch

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.InputMethodManager
import com.bumptech.glide.load.engine.Resource
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMapSearchBinding
import com.example.coupangeats.src.main.address.mapSearch.fragment.SearchAddressKeywordFragment
import com.example.coupangeats.src.main.address.models.SearchAddressResult

const val TAG = "LOG"

class MapSearchActivity: BaseActivity<ActivityMapSearchBinding>(ActivityMapSearchBinding::inflate), MapSearchView {
    private lateinit var searchTxt: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //엔터 누르면 주소검색
        binding.etSearchAddress.setOnKeyListener { v, keyCode, event ->

            supportFragmentManager.beginTransaction().replace(R.id.frame_map_detail, SearchAddressSettingFragment()).commitAllowingStateLoss()

            if((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)){

                //엔터 누르면 키보드 자동 내리기
                val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(binding.etSearchAddress.windowToken, 0)

                searchTxt = binding.etSearchAddress.text.toString()
                Log.d(TAG, "MapSearchActivity - onCreate() : 검색어 : $searchTxt")

                MapSearchService(this).getSearchAddress(searchTxt, resources.getString(R.string.Kakao_Authorization))

                supportFragmentManager.beginTransaction().replace(R.id.frame_map_detail, SearchAddressKeywordFragment()).commitAllowingStateLoss()

                true
            }else false
        }


        supportFragmentManager.beginTransaction().replace(R.id.frame_map_detail, SearchAddressSettingFragment()).commitAllowingStateLoss()


    }

    override fun getSearchAddressSuccess(response: SearchAddressResult) {

    }

    override fun getSearchAddressFailure(message: String) {

    }
}