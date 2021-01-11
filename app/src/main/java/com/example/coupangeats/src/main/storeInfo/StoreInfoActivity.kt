package com.example.coupangeats.src.main.storeInfo

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityStoreInfoBinding
import com.example.coupangeats.src.main.storeInfo.adapter.StoreViewPagerAdapter
import com.example.coupangeats.src.main.storeInfo.menu.MenuCategoryRecyclerViewAdapter
import com.example.coupangeats.src.main.storeInfo.models.CategoryMenu
import com.example.coupangeats.src.main.storeInfo.models.StoreInfoResult
import java.util.*
import kotlin.collections.ArrayList

const val TAG = "STORE_INFO"

class StoreInfoActivity : BaseActivity<ActivityStoreInfoBinding>(ActivityStoreInfoBinding::inflate),
    StoreActivityView {

    private lateinit var storeViewPagerAdapter: StoreViewPagerAdapter
    private lateinit var timer: Timer

    private var categoryMenuList = ArrayList<CategoryMenu>()
    private lateinit var menuCategoryRecyclerViewAdapter: MenuCategoryRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = binding.toolbar

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true) //뒤로가기 버튼
        //toolbar.title = "치킨치킨"


//        binding.appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener{
//            var isShow = true
//            var scrollRange = -1
//
//            override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
//                if(scrollRange == -1)   scrollRange = appBarLayout!!.totalScrollRange
//
//                if(scrollRange + verticalOffset == 0){
//                    binding.toolbar.title = "치킨치킨"
//                    isShow = true
//                }
//                else if(isShow) {
//                    binding.toolbar.title = ""
//                    isShow = false
//                }
//            }
//
//        })

        val storeIdx = intent.getIntExtra("storeIdx", 0)

        StoreService(this).getStoreInfo(storeIdx)

        storeViewPagerAdapter = StoreViewPagerAdapter()

        binding.viewpagerStoreInfo.apply {
            adapter = storeViewPagerAdapter
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

        menuCategoryRecyclerViewAdapter = MenuCategoryRecyclerViewAdapter()

        binding.recyclerViewStoreInfo.apply {
            adapter = menuCategoryRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

    }


    override fun onGetStoreInfoSuccess(response: StoreInfoResult) {
        Log.d(TAG, "StoreInfoActivity - onGetStoreInfoSuccess() : ${response}")
        storeViewPagerAdapter.submitList(response.storePhoto)

        Log.d(TAG, "StoreInfoActivity - onGetStoreInfoSuccess() : response.categoryMenu : ${response.categoryMenu}")

        response.categoryMenu.forEach {
            categoryMenuList.add(it)
        }
        menuCategoryRecyclerViewAdapter.submitList(categoryMenuList)

    }

    override fun onGetStoreInfoFailure(message: String) {

    }
}