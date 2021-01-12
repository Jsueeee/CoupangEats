package com.example.coupangeats.src.main.menuInfo

import android.os.Bundle
import android.os.Handler
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMenuInfoBinding
import com.example.coupangeats.src.main.menuInfo.models.MenuInfoResult
import com.example.coupangeats.src.main.menuInfo.viewPager.MenuViewPagerAdapter
import com.example.coupangeats.src.main.storeInfo.viewpager.StoreViewPagerAdapter
import java.util.*
import kotlin.collections.ArrayList

class MenuInfoActivity: BaseActivity<ActivityMenuInfoBinding>(ActivityMenuInfoBinding::inflate) , MenuActivityVeiw{

    private var menuIdx = 0

    private lateinit var menuViewPagerAdapter: MenuViewPagerAdapter
    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        menuIdx = intent.getIntExtra("menuIdx", 0)

        MenuService(this).getMenuInfo(menuIdx)

        menuViewPagerAdapter = MenuViewPagerAdapter()
        binding.viewpagerMenuInfo.apply {
            adapter = menuViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL

            var currentPage = 0
            val handler = Handler()
            val Update = Runnable {
                if (currentPage == 3) {
                    currentPage = 0
                }
                setCurrentItem(currentPage++, true)
            }
            timer = Timer()
            timer.schedule(object : TimerTask() {
                override fun run() {
                    handler.post(Update)
                }

            }, 500, 3000)
        }



    }

    override fun onGetMenuInfoSuccess(response: MenuInfoResult) {
        menuViewPagerAdapter.submitList(response.menuPhoto as ArrayList<String>)

    }

    override fun onGetMenuInfoFailure(message: String) {
        TODO("Not yet implemented")
    }
}