package com.example.coupangeats.src.main.myPage

import android.os.Bundle
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMainBinding
import com.example.coupangeats.databinding.ActivitySettingBinding
import com.nhn.android.naverlogin.OAuthLogin

class SettingActivity: BaseActivity<ActivitySettingBinding>(ActivitySettingBinding::inflate) {

    private var OauthLoginModule = OAuthLogin.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.btnLogout.setOnClickListener {
            OauthLoginModule.logout(this)
        }
    }
}