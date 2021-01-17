package com.example.coupangeats.src.main.myPage

import android.os.Bundle
import android.util.Log
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMainBinding
import com.example.coupangeats.databinding.ActivitySettingBinding
import com.kakao.sdk.user.UserApiClient
import com.nhn.android.naverlogin.OAuthLogin

const val TAG = "LOG"

class SettingActivity: BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate) {

    private var OauthLoginModule = OAuthLogin.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnLogout.setOnClickListener {
            // 네이버 로그아웃
            OauthLoginModule.logout(this)
            Log.d(TAG, "SettingActivity - onCreate() : 네이버 로그아웃")

            // 카카오 로그아웃
            UserApiClient.instance.logout { error ->
                if (error != null) {
                    Log.e(TAG, "카카오 로그아웃 실패. SDK에서 토큰 삭제됨", error)
                }
                else {
                    Log.i(TAG, "카카오 로그아웃 성공. SDK에서 토큰 삭제됨")
                }
            }
        }
    }
}