package com.example.coupangeats.src.main.myPage

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass.Companion.KaKaoAccessToken
import com.example.coupangeats.config.ApplicationClass.Companion.NaverAccessToken
import com.example.coupangeats.config.ApplicationClass.Companion.userName
import com.example.coupangeats.config.ApplicationClass.Companion.userNumberOrEmail
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentMypageBinding
import com.example.coupangeats.src.main.myPage.coupon.CouponActivity
import com.example.coupangeats.src.main.myPage.models.NaverUserInfoResult

class MyPageFragment : BaseFragment<FragmentMypageBinding>(
    FragmentMypageBinding::bind,
    R.layout.fragment_mypage
), MyPageFragmentView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myPageSetting.setOnClickListener {
            val intent = Intent(context, SettingActivity::class.java)
            startActivity(intent)
        }

        binding.userName.text = userName
        binding.userEmailOrNumber.text = userNumberOrEmail

        MyPageService(this).getUserInfo(NaverAccessToken)

        binding.btnCouponView.setOnClickListener {
            val intent = Intent(context, CouponActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onGetNaverUserInfoSuccess(response: NaverUserInfoResult) {
        KaKaoAccessToken = ""
        val phoneNumberEndString = response.response.mobile.substring(9)
        binding.userName.text = response.response.name
        binding.userEmailOrNumber.text = "010-****-$phoneNumberEndString"
    }

    override fun onGetNaverUserInfoFailure(message: String) {
    }
}