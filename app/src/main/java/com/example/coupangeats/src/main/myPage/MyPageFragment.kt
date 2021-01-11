package com.example.coupangeats.src.main.myPage

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass.Companion.userName
import com.example.coupangeats.config.ApplicationClass.Companion.userNumberOrEmail
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentMypageBinding

class MyPageFragment : BaseFragment<FragmentMypageBinding>(
    FragmentMypageBinding::bind,
    R.layout.fragment_mypage
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageSetting.setOnClickListener {
            val intent = Intent(context, SettingActivity::class.java)
            startActivity(intent)
        }

        binding.userName.text = userName
        binding.userEmailOrNumber.text = userNumberOrEmail
    }
}