package com.example.coupangeats.src.main.menuInfo

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityMenuInfoBinding
import com.example.coupangeats.src.main.menuInfo.models.CartRequest
import com.example.coupangeats.src.main.menuInfo.models.CartResponse
import com.example.coupangeats.src.main.menuInfo.models.MenuInfoResult
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        menuIdx = intent.getIntExtra("menuIdx", 0)
        storeIdx = intent.getIntExtra("storeIdx", 0)

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


        optionList.add(1)
        optionList.add(5)
        optionList.add(7)

        binding.btnCart.setOnClickListener{
            MenuService(this).postCartRequest(CartRequest(storeIdx, menuIdx, 1, optionList))
            Log.d(TAG, "MenuInfoActivity - onCreate() : 카트 담기 api 호출에 필요한 데이터 $storeIdx / $menuIdx / $optionList")
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

                    binding.radioGroup1.orientation = LinearLayout.VERTICAL

                    it.optmenuList.forEach {
                        val radioButton = RadioButton(this)
                        radioButton.text = it.menuOptName
                        radioButton.hint = it.menuOptPrice.toString()
                        binding.radioGroup1.addView(radioButton)
                    }
                }else{
                    binding.radioGroup1.orientation = LinearLayout.VERTICAL

                    it.optmenuList.forEach {
                        val radioButton = RadioButton(this)
                        radioButton.text = it.menuOptName
                        radioButton.hint = it.menuOptPrice.toString()
                        binding.radioGroup1.addView(radioButton)
                    }
                }

            } else if (it.optCategoryIdx == 2) {
                binding.optionCategoryName2.text = it.optCategoryName
                binding.optionCategoryLinear2.visibility = View.VISIBLE
                if (it.isMandatory == "Y"){
                    binding.mandatory2.visibility = View.VISIBLE

                    binding.radioGroup2.orientation = LinearLayout.VERTICAL

                    it.optmenuList.forEach {
                        val radioButton = RadioButton(this)
                        radioButton.text = it.menuOptName
                        radioButton.hint = it.menuOptPrice.toString()
                        binding.radioGroup2.addView(radioButton)
                    }
                }else{
                    binding.radioGroup2.orientation = LinearLayout.VERTICAL

                    it.optmenuList.forEach {
                        val radioButton = RadioButton(this)
                        radioButton.text = it.menuOptName
                        radioButton.hint = it.menuOptPrice.toString()
                        binding.radioGroup2.addView(radioButton)
                    }

                }


            } else if (it.optCategoryIdx == 3) {
                binding.optionCategoryName3.text = it.optCategoryName
                binding.optionCategoryLinear3.visibility = View.VISIBLE
                if (it.isMandatory == "Y"){
                    binding.mandatory3.visibility = View.VISIBLE

                    binding.radioGroup3.orientation = LinearLayout.VERTICAL

                    it.optmenuList.forEach {
                        val radioButton = RadioButton(this)
                        radioButton.text = it.menuOptName
                        radioButton.hint = it.menuOptPrice.toString()
                        binding.radioGroup3.addView(radioButton)
                    }
                }
                else{
                    //필수 선택 아닐 때
                    binding.radioGroup3.orientation = LinearLayout.VERTICAL

                    it.optmenuList.forEach {
                        val radioButton = RadioButton(this)
                        radioButton.text = it.menuOptName
                        radioButton.hint = it.menuOptPrice.toString()
                        binding.radioGroup3.addView(radioButton)
                    }
                }

            } else {
                Log.d(TAG, "MenuInfoActivity - onGetMenuInfoSuccess() : 옵션 카테고리 확인")
            }
        }

    }

    override fun onGetMenuInfoFailure(message: String) {

    }

    override fun onPostCartRequestSuccess(response: CartResponse) {

    }

    override fun onPostCartRequestFailure(message: String) {

    }
}