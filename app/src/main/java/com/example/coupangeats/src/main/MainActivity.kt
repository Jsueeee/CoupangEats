package com.example.coupangeats.src.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMainBinding
import com.example.coupangeats.src.main.bookMark.BookMarkFragment
import com.example.coupangeats.src.main.home.HomeFragment
import com.example.coupangeats.src.main.myPage.MyPageFragment
import com.example.coupangeats.src.main.myPage.SignInDialog
import com.example.coupangeats.src.main.order.OrderFragment
import com.example.coupangeats.src.main.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction().replace(R.id.frame_main, HomeFragment())
            .commitAllowingStateLoss()

        binding.bottomNavigationView.setOnNavigationItemSelectedListener (
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.menu_main_bottom_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_main, HomeFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_bottom_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_main, SearchFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_bottom_bookmark -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_main, BookMarkFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_bottom_order -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_main, OrderFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.menu_main_bottom_mypage -> {
                        val signInDialog = SignInDialog(this, this)
                        signInDialog.show()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.frame_main, MyPageFragment())
                            .commitAllowingStateLoss()
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }
        )
    }
}