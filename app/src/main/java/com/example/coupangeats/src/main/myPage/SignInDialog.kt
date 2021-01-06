package com.example.coupangeats.src.main.myPage

import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.WindowManager
import android.widget.Toast
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.config.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.coupangeats.databinding.SignInDialogBinding
import com.example.coupangeats.src.main.MainActivity
import com.example.coupangeats.src.main.home.HomeFragment
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.nhn.android.naverlogin.OAuthLogin
import com.nhn.android.naverlogin.OAuthLoginHandler


class SignInDialog(context: Context, private var activity: Activity) : Dialog(context) {

    private lateinit var binding: SignInDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = SignInDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        window!!.setBackgroundDrawable(ColorDrawable())
        window!!.setGravity(Gravity.BOTTOM)
        val params: WindowManager.LayoutParams = window!!.attributes
        params.width = ActionBar.LayoutParams.MATCH_PARENT
        params.height = 900
        window!!.attributes = params
        window!!.attributes.windowAnimations = R.style.DialogAnimation


        // 로그인 공통 callback 구성
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e(TAG, "로그인 실패", error)
            } else if (token != null) {
                Log.i(TAG, "로그인 성공 ${token.accessToken}")
                X_ACCESS_TOKEN = token.accessToken
            }
        }

        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        binding.btnKakaoLogin.setOnClickListener {
            if (LoginClient.instance.isKakaoTalkLoginAvailable(context)) {
                LoginClient.instance.loginWithKakaoTalk(context, callback = callback)
            } else {
                LoginClient.instance.loginWithKakaoAccount(context, callback = callback)
            }
        }

        // 토큰 정보 보기
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Log.e(TAG, "토큰 정보 보기 실패", error)
            } else if (tokenInfo != null) {
                Log.i(
                    TAG, "토큰 정보 보기 성공" +
                            "\n회원번호: ${tokenInfo.id}" +
                            "\n만료시간: ${tokenInfo.expiresIn} 초"
                )
            }
        }

        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error)
            } else if (user != null) {
                Log.i(
                    TAG, "사용자 정보 요청 성공" +
                            "\n회원번호: ${user.id}" +
                            "\n이메일: ${user.kakaoAccount?.email}" +
                            "\n닉네임: ${user.kakaoAccount?.profile?.nickname}" +
                            "\n전화번호: ${user.kakaoAccount?.phoneNumber}" +
                            "\n프로필사진: ${user.kakaoAccount?.profile?.thumbnailImageUrl}"
                )
            }
        }

        UserApiClient.instance.me { user, error ->
            if (error != null) {
                Log.e(TAG, "사용자 정보 요청 실패", error)
            } else if (user != null) {
                if (user.kakaoAccount?.email != null) {
                    Log.i(TAG, "이메일: ${user.kakaoAccount?.email}")
                } else if (user.kakaoAccount?.emailNeedsAgreement == false) {
                    Log.e(TAG, "사용자 계정에 이메일 없음. 꼭 필요하다면 동의항목 설정에서 수집 기능을 활성화 해보세요.")
                } else if (user.kakaoAccount?.emailNeedsAgreement == true) {
                    Log.d(TAG, "사용자에게 이메일 제공 동의를 받아야 합니다.")

                    // 사용자에게 이메일 제공 동의 요청
                    val scopes = listOf("account_email")
                    LoginClient.instance.loginWithNewScopes(context, scopes) { token, error ->
                        if (error != null) {
                            Log.e(TAG, "이메일 제공 동의 실패", error)
                        } else {
                            Log.d(TAG, "allowed scopes: ${token!!.scopes}")

                            // 사용자 정보 재요청
                            UserApiClient.instance.me { user, error ->
                                if (error != null) {
                                    Log.e(TAG, "사용자 정보 요청 실패", error)
                                } else if (user != null) {
                                    Log.i(TAG, "이메일: ${user.kakaoAccount?.email}")
                                }
                            }
                        }
                    }
                }
            }
        }


        binding.btnNaverLogin.setOnClickListener {

            val mOAuthLoginModule = OAuthLogin.getInstance();
            mOAuthLoginModule.init(
                context, "8fQ2xbY9U5mSCF6P71jJ", "7ESDJuk34Z", "Coupang Eats"
                //,OAUTH_CALLBACK_INTENT
                // SDK 4.1.4 버전부터는 OAUTH_CALLBACK_INTENT변수를 사용하지 않습니다.
            );

            val mOAuthLoginHandler: OAuthLoginHandler = @SuppressLint("HandlerLeak")
            object : OAuthLoginHandler() {
                override fun run(success: Boolean) {
                    if (success) {
                        val accessToken: String = mOAuthLoginModule.getAccessToken(context)
                        val refreshToken: String = mOAuthLoginModule.getRefreshToken(context)
                        val expiresAt: Long = mOAuthLoginModule.getExpiresAt(context)
                        val tokenType: String = mOAuthLoginModule.getTokenType(context)
                        Log.d(TAG, "SignInDialog - run() : 네이버 로그인 성공 / $accessToken")
                        X_ACCESS_TOKEN = accessToken
                        dismiss()
                    } else {
                        val errorCode: String =
                            mOAuthLoginModule.getLastErrorCode(context).code
                        val errorDesc: String = mOAuthLoginModule.getLastErrorDesc(context)
                        Log.d(
                            TAG,
                            "SignInDialog - run() : / errorCode: $errorCode errorDesc: $errorDesc"
                        )
                    }
                }
            }

            mOAuthLoginModule.startOauthLoginActivity(activity, mOAuthLoginHandler)
        }

    }

    override fun dismiss() {
        super.dismiss()
    }

    override fun hide() {
        super.hide()
    }

    override fun show() {
        if (!this.isShowing) super.show()
    }
}