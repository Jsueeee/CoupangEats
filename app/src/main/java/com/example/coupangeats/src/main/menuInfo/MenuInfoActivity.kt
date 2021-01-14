package com.example.coupangeats.src.main.menuInfo

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMenuInfoBinding
import com.example.coupangeats.src.main.menuInfo.models.CartRequest
import com.example.coupangeats.src.main.menuInfo.models.CartResponse
import com.example.coupangeats.src.main.menuInfo.models.MenuInfoResult
import com.example.coupangeats.src.main.menuInfo.models.Optmenu
import com.example.coupangeats.src.main.menuInfo.recyclerview.MenuInfoRecyclerviewAdapter
import com.example.coupangeats.src.main.menuInfo.viewPager.MenuViewPagerAdapter
import java.util.*
import kotlin.collections.ArrayList

const val TAG = "LOG"

class MenuInfoActivity : BaseActivity<ActivityMenuInfoBinding>(ActivityMenuInfoBinding::inflate),
    MenuActivityView {

    private var menuIdx = 0
    private var storeIdx = 0
    private var optionList = ArrayList<Int>()

    private lateinit var menuViewPagerAdapter: MenuViewPagerAdapter
    private lateinit var timer: Timer

    private lateinit var menuInfoRecyclerviewAdapter: MenuInfoRecyclerviewAdapter
    private lateinit var menuInfoRecyclerviewAdapter2: MenuInfoRecyclerviewAdapter
    private lateinit var menuInfoRecyclerviewAdapter3: MenuInfoRecyclerviewAdapter
    private var menuInfoList1 = ArrayList<Optmenu>()
    private var menuInfoList2 = ArrayList<Optmenu>()
    private var menuInfoList3 = ArrayList<Optmenu>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        menuIdx = intent.getIntExtra("menuIdx", 0)
        storeIdx = intent.getIntExtra("storeIdx", 0)

        MenuService(this).getMenuInfo(menuIdx)

        menuInfoRecyclerviewAdapter = MenuInfoRecyclerviewAdapter()
        binding.recyclerViewOptionCategoryMenu1.apply {
            adapter = menuInfoRecyclerviewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        menuInfoRecyclerviewAdapter2 = MenuInfoRecyclerviewAdapter()
        binding.recyclerViewOptionCategoryMenu2.apply {
            adapter = menuInfoRecyclerviewAdapter2
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        menuInfoRecyclerviewAdapter3 = MenuInfoRecyclerviewAdapter()
        binding.recyclerViewOptionCategoryMenu3.apply {
            adapter = menuInfoRecyclerviewAdapter3
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

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


        optionList.add(1)
        optionList.add(5)
        optionList.add(7)

        binding.btnCart.setOnClickListener {
            MenuService(this).postCartRequest(CartRequest(storeIdx, menuIdx, 1, optionList))
            Log.d(
                TAG,
                "MenuInfoActivity - onCreate() : 카트 담기 api 호출에 필요한 데이터 $storeIdx / $menuIdx / $optionList"
            )
        }

    }

    override fun onGetMenuInfoSuccess(response: MenuInfoResult) {
        menuViewPagerAdapter.submitList(response.menuPhoto as ArrayList<String>)

        binding.menuName.text = response.menuInfo[0].menuName
        binding.menuDetail.text = response.menuInfo[0].menuDetail
        binding.menuPrice.text = "${response.menuInfo[0].menuPrice}원"

        response.optCategoryMenu.forEach {
            if (it.optCategoryIdx == 1) {
                binding.optionCategoryName1.text = it.optCategoryName
                if (it.isMandatory == "Y") {
                    binding.mandatory1.visibility = View.VISIBLE
                }
                it.optmenuList.forEach {
                    menuInfoList1.add(it)
                }

            } else if (it.optCategoryIdx == 2) {
                binding.optionCategoryName2.text = it.optCategoryName
                binding.optionCategoryLinear2.visibility = View.VISIBLE

                if (it.isMandatory == "Y") {
                    binding.mandatory2.visibility = View.VISIBLE
                }
                it.optmenuList.forEach {
                    menuInfoList2.add(it)
                }
            } else if (it.optCategoryIdx == 3) {
                binding.optionCategoryName3.text = it.optCategoryName
                binding.optionCategoryLinear3.visibility = View.VISIBLE
                if (it.isMandatory == "Y") {
                    binding.mandatory3.visibility = View.VISIBLE
                } else {
                    Log.d(TAG, "MenuInfoActivity - onGetMenuInfoSuccess() : 옵션 카테고리 확인")
                }
                it.optmenuList.forEach {
                    menuInfoList3.add(it)
                }
            }

        }
        menuInfoRecyclerviewAdapter.submitList(menuInfoList1)
        Log.d(TAG, "MenuInfoActivity - onGetMenuInfoSuccess() : 메뉴리스트 $menuInfoList1")
        menuInfoRecyclerviewAdapter2.submitList(menuInfoList2)
        menuInfoRecyclerviewAdapter3.submitList(menuInfoList3)



    }
    override fun onGetMenuInfoFailure(message: String) {

    }

    override fun onPostCartRequestSuccess(response: CartResponse) {

    }

    override fun onPostCartRequestFailure(message: String) {

    }
}