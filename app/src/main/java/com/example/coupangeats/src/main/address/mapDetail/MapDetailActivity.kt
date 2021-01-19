package com.example.coupangeats.src.main.address.mapDetail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMapDetailBinding
import com.example.coupangeats.src.main.MainActivity
import com.example.coupangeats.src.main.address.map.MapActivity
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

        Log.d(
            TAG,
            "MapDetailActivity - onCreate() : $latitude / $longitude / $address / $buildingName / $addressDetail"
        )


        binding.mapDetailTxtTitle.text = buildingName
        binding.mapDetailTxtSubtitle.text = address

        binding.btnMap.setOnClickListener {
            val intent = Intent(this, MapActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }

        binding.btnAddressComplete.setOnClickListener {
            addressDetail = binding.etAddressDetail.text.toString() //상세주소 저장

            // 서버에 전송

            //개발 단계 사용 x
            val addressInfoRequest =
                AddressInfoRequest(latitude, longitude, address, buildingName, addressDetail)

//            // 개발 단계 임시 주소 사용
//            val addressInfoRequest =
//                AddressInfoRequest(
//                    37.336195,
//                    126.863623,
//                    "경기 안산시 상록구 정재로 127",
//                    "우진아트빌",
//                    "123호"
//                )
            MapDetailService(this).patchAddressInfoRequest(addressInfoRequest)

            // 홈프래그먼트로 이동
            // "배달주소가 변경되었습니다" 다이얼로그

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }

    override fun onPatchAddressInfoRequestSuccess(response: SettingAddressResult) {

    }

    override fun onPatchAddressInfoRequestFailure(message: String) {

    }


}