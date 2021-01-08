package com.example.coupangeats.src.main.address

import android.os.Bundle
import android.util.Log
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMapDetailBinding

class MapDetailActivity : BaseActivity<ActivityMapDetailBinding>(ActivityMapDetailBinding::inflate) {
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
    }
}