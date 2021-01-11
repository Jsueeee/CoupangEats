package com.example.coupangeats.src.main.storeInfo

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityStoreInfoBinding
import com.example.coupangeats.src.main.home.decoration.CategoryDecoration
import com.example.coupangeats.src.main.home.decoration.MainStoreDecoration
import com.example.coupangeats.src.main.storeInfo.viewpager.StoreViewPagerAdapter
import com.example.coupangeats.src.main.storeInfo.menu.MenuCategoryRecyclerViewAdapter
import com.example.coupangeats.src.main.storeInfo.models.CategoryMenu
import com.example.coupangeats.src.main.storeInfo.models.PhotoReview
import com.example.coupangeats.src.main.storeInfo.models.StoreInfoResult
import com.example.coupangeats.src.main.storeInfo.review.ReviewDecoration
import com.example.coupangeats.src.main.storeInfo.review.ReviewRecyclerViewAdapter
import com.google.android.material.tabs.TabLayout
import java.util.*
import kotlin.collections.ArrayList

const val TAG = "STORE_INFO"

class StoreInfoActivity : BaseActivity<ActivityStoreInfoBinding>(ActivityStoreInfoBinding::inflate),
    StoreActivityView {

    private lateinit var storeViewPagerAdapter: StoreViewPagerAdapter
    private lateinit var timer: Timer

    private var categoryMenuList = ArrayList<CategoryMenu>()
    private lateinit var menuCategoryRecyclerViewAdapter: MenuCategoryRecyclerViewAdapter

    private var photoReviewList = ArrayList<PhotoReview>()
    private lateinit var reviewRecyclerViewAdapter: ReviewRecyclerViewAdapter


    var tabName = ArrayList<String>()
    lateinit var tab: TabLayout.Tab

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

        reviewRecyclerViewAdapter = ReviewRecyclerViewAdapter()
        binding.recyclerViewReview.apply {
            adapter = reviewRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            addItemDecoration(ReviewDecoration())
        }

    }


    override fun onGetStoreInfoSuccess(response: StoreInfoResult) {
        Log.d(TAG, "StoreInfoActivity - onGetStoreInfoSuccess() : ${response}")
        storeViewPagerAdapter.submitList(response.storePhoto)
        binding.storeName.text = response.storeInfo[0].storeName


        response.storeInfo.forEach {
            binding.storeName.text = it.storeName
            binding.storeStar.text = it.storeStar.toString()
            binding.deliveryTime.text = it.deliveryTime
            binding.deliveryFee.text = it.deliveryFee
            binding.minOrderCost.text = it.minOrderCost
            binding.reviewCount.text = "리뷰 ${it.reviewCount}개"
            if(it.isCheetah == "N"){
                binding.isCheetah.visibility = View.INVISIBLE
            }
        }

        Log.d(TAG, "StoreInfoActivity - onGetStoreInfoSuccess() : response.categoryMenu : ${response.categoryMenu}")

        response.categoryMenu.forEach {
            categoryMenuList.add(it)
            tabName.add(it.categoryName)
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(it.categoryName))
        }
        menuCategoryRecyclerViewAdapter.submitList(categoryMenuList)


        response.photoReview.forEach {
            photoReviewList.add(it)
        }
        reviewRecyclerViewAdapter.submitList(photoReviewList)

    }

    override fun onGetStoreInfoFailure(message: String) {

    }
}