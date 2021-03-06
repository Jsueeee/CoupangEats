package com.example.coupangeats.config

import android.app.Application
import android.content.SharedPreferences
import android.util.Log
import com.example.coupangeats.R
import com.example.coupangeats.src.main.home.HomeRetrofitInterface
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import com.nhn.android.naverlogin.OAuthLogin
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class ApplicationClass : Application() {

    val API_URL = "https://prod.coupang-eats.shop/"

    val NAVER_MAP_API_URL = "https://naveropenapi.apigw.ntruss.com/"
    val KAKAO_MAP_API_URL = "https://dapi.kakao.com/v2/local/search/"
    val NAVER_USER_API_URL = "https://openapi.naver.com/v1/"

    // 코틀린의 전역변수 문법
    companion object {
        const val TAG = "LOG"

        var isOrder = false

        lateinit var instance: ApplicationClass
            private set

        // 만들어져있는 SharedPreferences 를 사용해야합니다. 재생성하지 않도록 유념해주세요
        lateinit var sSharedPreferences: SharedPreferences

        // JWT Token Header 키 값
        var X_ACCESS_TOKEN = "X-ACCESS-TOKEN"

        var AccessTokenType = ""

        var KaKaoAccessToken: String = ""
        var NaverAccessToken: String = ""

        // Retrofit 인스턴스, 앱 실행시 한번만 생성하여 사용합니다.
        lateinit var sRetrofit: Retrofit

        lateinit var naverRetrofit: Retrofit
        lateinit var kakaoRetrofit: Retrofit
        lateinit var naverUserRetrofit: Retrofit

        //유저네임, 번호, 이메일
         var userName: String = ""
        var userNumberOrEmail: String = ""
    }

    // 앱이 처음 생성되는 순간, SP를 새로 만들어주고, 레트로핏 인스턴스를 생성합니다.
    override fun onCreate() {
        super.onCreate()

        instance = this


        var keyHash = Utility.getKeyHash(this)

        sSharedPreferences =
            applicationContext.getSharedPreferences(
                "SOFTSQUARED_TEMPLATE_APP",
                Application.MODE_PRIVATE
            )
        // 레트로핏 인스턴스 생성
        initRetrofitInstance()

        initNaverRetrofitInstance()
        initKaKaoRetrofitInstance()
        initNaverUserRetrofitInstance()

    }

    private fun initKaKaoRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor { message: String ->
                Log.d(
                    "network_info",
                    message
                )
            }.setLevel(HttpLoggingInterceptor.Level.BODY)) // API Response 로그 작성용
            .addNetworkInterceptor(XAccessTokenInterceptor())
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        kakaoRetrofit = Retrofit.Builder()
            .baseUrl(KAKAO_MAP_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initNaverRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor { message: String ->
                Log.d(
                    "network_info",
                    message
                )
            }.setLevel(HttpLoggingInterceptor.Level.BODY)) // API Response 로그 작성용
            .addNetworkInterceptor(XAccessTokenInterceptor())
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        naverRetrofit = Retrofit.Builder()
            .baseUrl(NAVER_MAP_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    // 레트로핏 인스턴스를 생성하고, 레트로핏에 각종 설정값들을 지정해줍니다.
    // 연결 타임아웃시간은 5초로 지정이 되어있고, HttpLoggingInterceptor를 붙여서 어떤 요청이 나가고 들어오는지를 보여줍니다.
    private fun initRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor { message: String ->
                Log.d(
                    "network_info",
                    message
                )
            }.setLevel(HttpLoggingInterceptor.Level.BODY)) // API Response 로그 작성용
            .addNetworkInterceptor(XAccessTokenInterceptor())
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        sRetrofit = Retrofit.Builder()
            .baseUrl(API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun initNaverUserRetrofitInstance() {
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(5000, TimeUnit.MILLISECONDS)
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor(HttpLoggingInterceptor { message: String ->
                Log.d(
                    "network_info",
                    message
                )
            }.setLevel(HttpLoggingInterceptor.Level.BODY)) // API Response 로그 작성용
            .addNetworkInterceptor(XAccessTokenInterceptor())
            .build()

        // sRetrofit 이라는 전역변수에 API url, 인터셉터, Gson을 넣어주고 빌드해주는 코드
        // 이 전역변수로 http 요청을 서버로 보내면 됩니다.
        naverUserRetrofit = Retrofit.Builder()
            .baseUrl(NAVER_USER_API_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}