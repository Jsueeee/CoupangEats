package com.example.coupangeats.src.main.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass.Companion.AccessTokenType
import com.example.coupangeats.config.ApplicationClass.Companion.KaKaoAccessToken
import com.example.coupangeats.config.ApplicationClass.Companion.NaverAccessToken
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.config.ApplicationClass.Companion.isOrder
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentHomeBinding
import com.example.coupangeats.src.main.DetailListNewStore.DetailListNewStoreActivity
import com.example.coupangeats.src.main.address.mapSearch.MapSearchActivity
import com.example.coupangeats.src.main.cartOrder.CartOrderActivity
import com.example.coupangeats.src.main.detailListFranchise.DetailFranchiseActivity
import com.example.coupangeats.src.main.home.adapter.*
import com.example.coupangeats.src.main.home.decoration.CategoryDecoration
import com.example.coupangeats.src.main.home.decoration.MainStoreDecoration
import com.example.coupangeats.src.main.home.decoration.RecyclerItemDecoration
import com.example.coupangeats.src.main.home.itemInterface.CategoryRecyclerViewInterface
import com.example.coupangeats.src.main.home.itemInterface.FamRestaurantRecyclerViewInterface
import com.example.coupangeats.src.main.home.itemInterface.TopViewPagerInterface
import com.example.coupangeats.src.main.home.models.*
import com.example.coupangeats.src.main.storeInfo.StoreInfoActivity
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView, CategoryRecyclerViewInterface, TopViewPagerInterface, FamRestaurantRecyclerViewInterface {

    private var promotionList = ArrayList<Promotion>()
    private lateinit var topViewPagerAdapter: TopViewPagerAdapter

    private var categoryItemList = ArrayList<CategoryItem>()
    private lateinit var categoryRecyclerViewAdapter: CategoryRecyclerViewAdapter

    private var franchiseList = ArrayList<Franchise>()
    private lateinit var franchiseRecyclerViewAdapter: FranchiseRecyclerViewAdapter

    private var famRestaurantItemList = ArrayList<MainStore>()
    private lateinit var famRestaurantRecyclerViewAdapter: FamRestaurantRecyclerViewAdapter

    private var openStoreItmeList = ArrayList<OpenStore>()
    private lateinit var openStoreRecyclerViewAdapter: OpenStoreRecyclerViewAdapter

    private lateinit var timer: Timer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "HomeFragment - onViewCreated() : ")

        if(isOrder == false){
            binding.btnCartView.visibility = View.GONE
        }else{
            binding.btnCartView.visibility = View.VISIBLE
        }
        if (AccessTokenType == "kakao") {
            HomeService(this).tryPostSignUpKaKao(PostSignUpRequest(KaKaoAccessToken))
            Log.d(TAG, "HomeFragment - onViewCreated() : 카카오 액세스 토큰 전달 완료 $KaKaoAccessToken")
        }
        if (AccessTokenType == "naver") {
            HomeService(this).tryPostSignUpNaver(PostSignUpRequest(NaverAccessToken))
            Log.d(TAG, "HomeFragment - onViewCreated() : 네이버 액세스 토큰 전달 완료 $NaverAccessToken")
        }
        HomeService(this).getHomeResult()

        binding.textView3.setOnClickListener {
            val intent = Intent(context, MapSearchActivity::class.java)
            startActivity(intent)
        }


        topViewPagerAdapter = TopViewPagerAdapter(this)

        binding.homeTopViewpager.apply {
            adapter = topViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL

            var currentPage = 0
            val handler = Handler()
            val Update = Runnable {
                if (currentPage == 6) {
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


        addCategoryItem()
        categoryRecyclerViewAdapter = CategoryRecyclerViewAdapter(this)

        categoryRecyclerViewAdapter.submitList(categoryItemList)
        binding.recyclerviewHomeMenuCategory.apply {
            adapter = categoryRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            addItemDecoration(CategoryDecoration())
        }

        franchiseRecyclerViewAdapter = FranchiseRecyclerViewAdapter()
        binding.recyclerViewFranchise.apply {
            adapter = franchiseRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            addItemDecoration(RecyclerItemDecoration())
        }

        famRestaurantRecyclerViewAdapter = FamRestaurantRecyclerViewAdapter(this)
        binding.recyclerViewFamousRestaurant.apply {
            adapter = famRestaurantRecyclerViewAdapter
            layoutManager = LinearLayoutManager(
                context, RecyclerView.VERTICAL, false
            )
            addItemDecoration(MainStoreDecoration())
        }

        openStoreRecyclerViewAdapter = OpenStoreRecyclerViewAdapter()
        binding.recyclerViewOpenStore.apply {
            adapter = openStoreRecyclerViewAdapter
            layoutManager = LinearLayoutManager(
                context, RecyclerView.HORIZONTAL, false
            )
            addItemDecoration(RecyclerItemDecoration())
        }

        binding.btnArrowFranchise.setOnClickListener {
            val intent = Intent(context, DetailFranchiseActivity::class.java)
            startActivity(intent)
        }

        binding.btnArrowNew.setOnClickListener {
            val intent = Intent(context, DetailListNewStoreActivity::class.java)
            startActivity(intent)
        }

        binding.btnCartView.setOnClickListener {
            val intent = Intent(context, CartOrderActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "HomeFragment - onResume() : ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "HomeFragment - onPause() : ")
    }

    private fun addCategoryItem() {
        categoryItemList.add(CategoryItem(R.drawable.category_1, "1인분"))
        categoryItemList.add(CategoryItem(R.drawable.category_2, "한식"))
        categoryItemList.add(CategoryItem(R.drawable.category_3, "치킨"))
        categoryItemList.add(CategoryItem(R.drawable.category_4, "분식"))
        categoryItemList.add(CategoryItem(R.drawable.category_5, "돈까스"))
        categoryItemList.add(CategoryItem(R.drawable.category_6, "족발/보쌈"))
        categoryItemList.add(CategoryItem(R.drawable.category_7, "찜/탕"))
        categoryItemList.add(CategoryItem(R.drawable.category_8, "구이"))
        categoryItemList.add(CategoryItem(R.drawable.category_9, "피자"))
        categoryItemList.add(CategoryItem(R.drawable.category_10, "중식"))
        categoryItemList.add(CategoryItem(R.drawable.category_11, "일식"))
        categoryItemList.add(CategoryItem(R.drawable.category_12, "회/해물"))
        categoryItemList.add(CategoryItem(R.drawable.category_13, "양식"))
        categoryItemList.add(CategoryItem(R.drawable.category_14, "커피/차"))
        categoryItemList.add(CategoryItem(R.drawable.category_15, "디저트"))
        categoryItemList.add(CategoryItem(R.drawable.category_16, "간식"))
        categoryItemList.add(CategoryItem(R.drawable.category_17, "아시안"))
        categoryItemList.add(CategoryItem(R.drawable.category_18, "샌드위치"))
        categoryItemList.add(CategoryItem(R.drawable.category_19, "샐러드"))
        categoryItemList.add(CategoryItem(R.drawable.category_20, "버거"))
        categoryItemList.add(CategoryItem(R.drawable.category_21, "멕시칸"))
        categoryItemList.add(CategoryItem(R.drawable.category_22, "도시락"))
        categoryItemList.add(CategoryItem(R.drawable.category_23, "죽"))
        categoryItemList.add(CategoryItem(R.drawable.category_24, "프랜차이즈"))
    }

    override fun onItemClicked(position: Int) {
    }

    override fun onGetHomeResultSuccess(response: HomeResultResponse) {

        if(response.result == null){
            Log.d(TAG, "HomeFragment - onGetHomeResultSuccess() : result is null")
        }else{
            Log.d(
                TAG,
                "HomeFragment - onGetHomeResultSuccess() : response.result.promotion / ${response.result.promotion}"
            )
            response.result.promotion.forEach {
                promotionList.add(it)
            }
            response.result.franchise.forEach {
                franchiseList.add(it)
            }
            response.result.mainStore.forEach {
                famRestaurantItemList.add(it)
            }
            response.result.openStore.forEach {
                openStoreItmeList.add(it)
            }

            topViewPagerAdapter.submitList(promotionList)
            franchiseRecyclerViewAdapter.submitList(franchiseList)
            famRestaurantRecyclerViewAdapter.submitList(famRestaurantItemList)
            openStoreRecyclerViewAdapter.submitList(openStoreItmeList)
        }

    }

    override fun onGetHomeResultFailure(message: String) {
        showCustomToast("api 호출 실패 $message")
    }

    override fun onPostSignUpSuccess(response: SignUpResponse) {
        Log.d(TAG, "HomeFragment - onPostSignUpSuccess() : $response")

    }

    override fun onPostSignUpFailure(message: String) {
        Log.d(TAG, "HomeFragment - onPostSignUpFailure() : $message")
    }

    override fun onFamRestaurantItemClicked(storeIdx: Int) {
        val intent = Intent(context, StoreInfoActivity::class.java)
        intent.putExtra("storeIdx", storeIdx)
        startActivity(intent)
    }


}