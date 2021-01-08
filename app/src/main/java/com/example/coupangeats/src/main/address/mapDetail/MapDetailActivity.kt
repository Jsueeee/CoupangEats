package com.example.coupangeats.src.main.address.mapDetail

import android.os.Bundle
import android.util.Log
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMapDetailBinding
import com.example.coupangeats.src.main.address.models.AddressInfoRequest
import com.example.coupangeats.src.main.address.models.SettingAddressResult

const val TAG = "LOG"

class MapDetailActivity : BaseActivity<ActivityMapDetailBinding>(ActivityMapDetailBinding::inflate),
    MapDetailView {
    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    private lateinit var address: String
    private lateinit var buildingName: String
    private lateinit var addressDetail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        latitude = intent.getDoubleExtra("latitude", 0.0)
        longitude = intent.getDoubleExtra("longitude", 0.0)
        address = intent.getStringExtra("address").toString()
        buildingName = intent.getStringExtra("buildingName").toString()
        addressDetail = intent.getStringExtra("addressDetail").toString()

        Log.d(TAG, "MapDetailActivity - onCreate() : $latitude / $longitude / $address / $buildingName / $addressDetail")


        binding.mapDetailTxtTitle.text = buildingName
        binding.mapDetailTxtSubtitle.text = address

        binding.btnAddressComplete.setOnClickListener {
            addressDetail = binding.etAddressDetail.text.toString() //상세주소 저장

            // 서버에 전송
            val addressInfoRequest = AddressInfoRequest(latitude, longitude, address, buildingName, addressDetail)
            MapDetailService(this).patchAddressInfoRequest(addressInfoRequest)

            // 홈프래그먼트로 이동
            // "배달주소가 변경되었습니다" 다이얼로그
        }
    }

    override fun onPatchAddressInfoRequestSuccess(response: SettingAddressResult) {

    }

    override fun onPatchAddressInfoRequestFailure(message: String) {

    }


}