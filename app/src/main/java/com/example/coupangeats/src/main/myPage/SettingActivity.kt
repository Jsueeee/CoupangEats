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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnLogout.setOnClickListener {

            SignOutDialog(this, this).show()
        }
    }
}