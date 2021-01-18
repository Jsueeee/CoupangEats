package com.example.coupangeats.src.main.storeInfo

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.ColorFilter
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityCouponBinding.bind
import com.example.coupangeats.databinding.ActivityCouponBinding.inflate
import com.example.coupangeats.databinding.ActivityStoreInfoBinding
import com.example.coupangeats.src.main.bookMark.BookMarkFragmentView
import com.example.coupangeats.src.main.bookMark.BookMarkService
import com.example.coupangeats.src.main.bookMark.models.MyBookMarkList
import com.example.coupangeats.src.main.home.decoration.CategoryDecoration
import com.example.coupangeats.src.main.home.decoration.MainStoreDecoration
import com.example.coupangeats.src.main.storeInfo.viewpager.StoreViewPagerAdapter
import com.example.coupangeats.src.main.storeInfo.menu.MenuCategoryRecyclerViewAdapter
import com.example.coupangeats.src.main.storeInfo.models.*
import com.example.coupangeats.src.main.storeInfo.review.ReviewDecoration
import com.example.coupangeats.src.main.storeInfo.review.ReviewRecyclerViewAdapter
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.tabs.TabLayout
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

const val TAG = "STORE_INFO"

class StoreInfoActivity : BaseActivity<ActivityStoreInfoBinding>(ActivityStoreInfoBinding::inflate),
    StoreActivityView, BookMarkFragmentView {

    private lateinit var storeViewPagerAdapter: StoreViewPagerAdapter
    private lateinit var timer: Timer

    private var categoryMenuList = ArrayList<CategoryMenu>()
    private lateinit var menuCategoryRecyclerViewAdapter: MenuCategoryRecyclerViewAdapter

    private var photoReviewList = ArrayList<PhotoReview>()
    private lateinit var reviewRecyclerViewAdapter: ReviewRecyclerViewAdapter

    private lateinit var storeIdx: StoreIdx

    var tabName = ArrayList<String>()
    lateinit var tab: TabLayout.Tab

    private var couponIdx = CouponIdx(0)
    private var couponCompleteTxt = ""

    private var isBookMark = false

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 현재매장 구별
        storeIdx = StoreIdx(intent.getIntExtra("storeIdx", 0))
        StoreService(this).getStoreInfo(storeIdx.storeIdx)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowCustomEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        //supportActionBar!!.setDisplayHomeAsUpEnabled(true) //뒤로가기 버튼

        // 이 매장이 즐겨찾기 되어있는지 아닌지 확인 필요
        BookMarkService(this).getBookMarkList()


        binding.appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if(abs(verticalOffset) - appBarLayout.totalScrollRange == 0){
                binding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                binding.toolbarTitle.visibility = View.VISIBLE
                binding.btnBack.setColorFilter(ContextCompat.getColor(this, R.color.black))
                binding.btnBookmark.setColorFilter(Color.parseColor("#F63772"))
                binding.btnShare.setColorFilter(ContextCompat.getColor(this, R.color.black))

            }else{
                binding.toolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.transparent))
                binding.toolbarTitle.visibility = View.GONE
                binding.btnBack.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.btnBookmark.setColorFilter(ContextCompat.getColor(this, R.color.white))
                binding.btnShare.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
        })

        binding.btnBookmark.setOnClickListener {
            StoreService(this).postStoreHeart(storeIdx)
            if(isBookMark == false){
                binding.btnBookmark.setImageDrawable(getDrawable(R.drawable.ic_baseline_favorite_24))
            }else{
                binding.btnBookmark.setImageDrawable(getDrawable(R.drawable.ic_baseline_favorite_border_24))
            }

        }

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

        binding.btnCouponDownload.setOnClickListener {
            it.background = ContextCompat.getDrawable(this, R.drawable.radius_gray)
            binding.btnCouponDownloadLogo.setImageResource(R.drawable.ic_baseline_check_24)
            binding.btnCouponText.text = couponCompleteTxt
            if(couponCompleteTxt == "")
                binding.btnCouponDownloadLogo.visibility = View.GONE
            binding.btnCouponText.setTextColor(Color.parseColor("#9A9A9A"))

            StoreService(this).postStoreCoupon(storeIdx.storeIdx, couponIdx)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_store_info, menu)

        return super.onCreateOptionsMenu(menu)
    }

//    @SuppressLint("UseCompatLoadingForDrawables")
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.btn_heart -> {
//                StoreService(this).postStoreHeart(storeIdx)
//                Log.d(TAG, "StoreInfoActivity - onCreate() : 즐겨찾기에 추가할 인덱스 : $storeIdx")
////                if(item.icon == getDrawable(R.drawable.ic_baseline_favorite_border_24)){
////                    item.icon = getDrawable(R.drawable.ic_baseline_favorite_24)
////                }else{
////                    item.icon = getDrawable(R.drawable.ic_baseline_favorite_border_24)
////                }
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onGetStoreInfoSuccess(response: StoreInfoResult) {
        Log.d(TAG, "StoreInfoActivity - onGetStoreInfoSuccess() : ${response}")
        storeViewPagerAdapter.submitList(response.storePhoto)
        binding.storeName.text = response.storeInfo[0].storeName

        response.storeInfo.forEach {
            binding.storeName.text = it.storeName
            binding.toolbarTitle.text = it.storeName
            binding.storeStar.text = it.storeStar.toString()
            binding.deliveryTime.text = it.deliveryTime
            binding.deliveryFee.text = it.deliveryFee
            binding.minOrderCost.text = it.minOrderCost
            binding.reviewCount.text = "리뷰 ${it.reviewCount}개"
            if (it.isCheetah == "N") {
                binding.isCheetah.visibility = View.INVISIBLE
            }
        }

        Log.d(
            TAG,
            "StoreInfoActivity - onGetStoreInfoSuccess() : response.categoryMenu : ${response.categoryMenu}"
        )

        response.categoryMenu.forEach {
            categoryMenuList.add(it)
            tabName.add(it.categoryName)
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(it.categoryName))
        }
        menuCategoryRecyclerViewAdapter.submitList(categoryMenuList, storeIdx.storeIdx)


        response.photoReview.forEach {
            photoReviewList.add(it)
        }
        reviewRecyclerViewAdapter.submitList(photoReviewList)

        if (response.couponInfo == null) {
            Log.d(TAG, "StoreInfoActivity - onGetStoreInfoSuccess() : 쿠폰정보 없음")
        } else {
            couponIdx = CouponIdx(response.couponInfo.couponIdx)
            couponCompleteTxt = response.couponInfo.coupon
            if(response.couponInfo.hasCoupon == "Y"){
                binding.btnCouponDownload.background = ContextCompat.getDrawable(this, R.drawable.radius_gray)
                binding.btnCouponDownloadLogo.setImageResource(R.drawable.ic_baseline_check_24)
                binding.btnCouponText.text = couponCompleteTxt
                if(couponCompleteTxt == "")
                    binding.btnCouponDownloadLogo.visibility = View.GONE
                binding.btnCouponText.setTextColor(Color.parseColor("#9A9A9A"))
            }

        }
    }

    override fun onGetStoreInfoFailure(message: String) {
    }

    override fun onPostHeartSuccess(response: HeartStoreResult) {

    }

    override fun onPostHeartFailure(message: String) {

    }

    override fun onPostStoreCouponSuccess(response: CouponDownResult) {

    }

    override fun onPostStoreCouponFailure(message: String) {

    }

    override fun onGetBookMarkListSuccess(response: MyBookMarkList) {
        if(response.heartStore == null){
            Log.d(TAG, "StoreInfoActivity - onGetBookMarkListSuccess() : 즐겨찾기 목록이 없습니다.")
        }
        else {
            response.heartStore.forEach {
                if (it.storeIdx == storeIdx.storeIdx) {
                    isBookMark = true
                }
            }
        }

        if(isBookMark == true){
            binding.btnBookmark.setImageDrawable(getDrawable(R.drawable.ic_baseline_favorite_24))
        }
    }

    override fun onGetBookMarkListFailure(message: String) {
        TODO("Not yet implemented")
    }
}