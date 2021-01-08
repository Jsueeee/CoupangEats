package com.example.coupangeats.src.main.address

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMapBinding
import com.example.coupangeats.src.main.address.models.ReverseGeocodingResult
import com.example.coupangeats.src.main.home.HomeService
import com.naver.maps.map.LocationTrackingMode
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.util.FusedLocationSource
import com.naver.maps.map.widget.LocationButtonView
import java.security.Permissions
import java.text.DecimalFormat

const val TAG = "LOG"

class MapActivity : BaseActivity<ActivityMapBinding>(ActivityMapBinding::inflate),
    OnMapReadyCallback, MapActivityView {


    private lateinit var locationSource: FusedLocationSource
    private lateinit var naverMap: NaverMap

    private var latitude: Double = 0.0
    private var longitude: Double = 0.0
    lateinit var address: String
    lateinit var buildingName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        locationSource =
            FusedLocationSource(this, LOCATION_PERMISSION_REQUEST_CODE)

        //지도 객체
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }

        mapFragment.getMapAsync(this)

        binding.btnMap.setOnClickListener {
            address = binding.mapTxtTitle.text.toString()
            buildingName = binding.mapTxtSubtitle.text.toString()

            val intent = Intent(this, MapDetailActivity::class.java)
            intent.putExtra("latitude", latitude)
            intent.putExtra("longitude", longitude)
            intent.putExtra("address", address)
            intent.putExtra("buildingName", buildingName)
            startActivity(intent)
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (locationSource.onRequestPermissionsResult(
                requestCode, permissions,
                grantResults
            )
        ) {
            if (!locationSource.isActivated) { // 권한 거부됨
                naverMap.locationTrackingMode = LocationTrackingMode.None
                Log.d(TAG, "MapActivity - onRequestPermissionsResult() : 위치 권한 거부")
            }
            return
        }

        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

    }

    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        naverMap.locationSource = locationSource

        val uiSettings = naverMap.uiSettings

//        //나침반 비활성화, 현위치 버튼 활성화
//        uiSettings.isCompassEnabled = false
//        uiSettings.isLocationButtonEnabled = true


        //follow 모드
        naverMap.locationTrackingMode = LocationTrackingMode.Follow

        val locationOverlay = naverMap.locationOverlay
        locationOverlay.isVisible = true

        val locationButtonView = binding.btnLocation as LocationButtonView
        locationButtonView.map = naverMap


        naverMap.addOnLocationChangeListener { location ->
            val myFormatterLatitude = DecimalFormat("##.######")
            latitude = myFormatterLatitude.format(location.latitude).toDouble()
            Log.d(TAG, "MapActivity - onCreate() : 위도 : $latitude ")

            val myFormatterLongitude = DecimalFormat("###.######")
            longitude = myFormatterLongitude.format(location.longitude).toDouble()
            Log.d(TAG, "MapActivity - onCreate() : 경도 : $longitude")

            val coords = ("$longitude,$latitude") //경도,위도 순
            Log.d(TAG, "MapActivity - onMapReady() : 위경도 : $coords")
            MapService(this, coords).getReverseGeocodingResult()
        }


    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000
    }

    override fun onGetReverseGeocodingSuccess(response: ReverseGeocodingResult) {
        Log.d(TAG, "MapActivity - onGetReverseGeocodingSuccess() : ")
        response.results.forEach {
            val address =
                "${it.region.area1.name} ${it.region.area2.name} ${it.land.name} ${it.land.number1}-${it.land.number2} "
            val buildingName = it.land.addition0.value
            Log.d(TAG, "MapActivity - onGetReverseGeocodingSuccess() : 주소 : $address")
            Log.d(TAG, "MapActivity - onGetReverseGeocodingSuccess() : 빌딩이름 : $buildingName")

            //buildingName 등록 안되어있으면 주소로 세팅
            if(buildingName == ""){
                binding.mapTxtTitle.text = address
            }else{
                binding.mapTxtTitle.text = buildingName
            }

            binding.mapTxtSubtitle.text = address
        }
    }

    override fun onGetReverseGeocodingFailure(message: String) {
        Log.d(TAG, "MapActivity - onGetReverseGeocodingFailure() : ")
    }
}