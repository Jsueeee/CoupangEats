package com.example.coupangeats.src.main.myPage

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat.startActivity
import com.example.coupangeats.config.ApplicationClass.Companion.AccessTokenType
import com.example.coupangeats.databinding.SignOutDialogBinding
import com.example.coupangeats.src.main.MainActivity
import com.kakao.sdk.user.UserApiClient
import com.nhn.android.naverlogin.OAuthLogin

class SignOutDialog(context: Context, private var activity: Activity) : Dialog(context) {

    private lateinit var binding: SignOutDialogBinding
    private var OauthLoginModule = OAuthLogin.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignOutDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        window!!.setBackgroundDrawable(ColorDrawable())
        window!!.setGravity(Gravity.CENTER)
        val params: WindowManager.LayoutParams = window!!.attributes
        params.width = 1300
        params.height = 420

        window!!.attributes = params

        binding.btnLogout.setOnClickListener {

            if (AccessTokenType == "naver") {
                // 네이버 로그아웃
                AccessTokenType = ""
                OauthLoginModule.logout(context)
                Log.d(TAG, "SettingActivity - onCreate() : 네이버 로그아웃")
                dismiss()
                val intent = Intent(context, MainActivity::class.java)
                startActivity(context, intent, null)
            } else if (AccessTokenType == "kakao") {
                AccessTokenType = ""
                // 카카오 로그아웃
                UserApiClient.instance.logout { error ->
                    if (error != null) {
                        Log.e(TAG, "카카오 로그아웃 실패. SDK에서 토큰 삭제됨", error)
                    } else {
                        Log.i(TAG, "카카오 로그아웃 성공. SDK에서 토큰 삭제됨")
                    }
                }
                dismiss()
                val intent = Intent(context, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(context, intent, null)
            } else {
                Log.d(TAG, "SignOutDialog - onCreate() : AccessTokenType is null")
            }
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

    }

    override fun show() {
        super.show()
    }
}