package com.example.coupangeats.src.main.home

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentHomeBinding
import com.example.coupangeats.src.main.home.models.CategoryItem
import com.example.coupangeats.src.main.home.models.PageItem

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView, CategoryRecyclerViewInterface {

    private var pageItemList = ArrayList<PageItem>()
    private lateinit var topViewPagerAdapter: TopViewPagerAdapter

    private var categoryItmeList = ArrayList<CategoryItem>()
    private lateinit var categoryRecyclerViewAdapter: CategoryRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pageItemList.add(PageItem(R.drawable.item_main1.toString()))
        pageItemList.add(PageItem(R.drawable.item_main2.toString()))

        topViewPagerAdapter = TopViewPagerAdapter(pageItemList)

        binding.homeTopViewpager.apply{
            adapter = topViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        addCategoryItem()
        categoryRecyclerViewAdapter = CategoryRecyclerViewAdapter(this)

        categoryRecyclerViewAdapter.submitList(categoryItmeList)
        binding.recyclerviewHomeMenuCategory.apply {
            adapter = categoryRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }
    }

    private fun addCategoryItem() {
        categoryItmeList.add(CategoryItem(R.drawable.category_1, "1인분"))
        categoryItmeList.add(CategoryItem(R.drawable.category_2, "한식"))
        categoryItmeList.add(CategoryItem(R.drawable.category_3, "치킨"))
        categoryItmeList.add(CategoryItem(R.drawable.category_4, "분식"))
        categoryItmeList.add(CategoryItem(R.drawable.category_5, "돈까스"))
        categoryItmeList.add(CategoryItem(R.drawable.category_6, "족발/보쌈"))
        categoryItmeList.add(CategoryItem(R.drawable.category_7, "찜/탕"))
        categoryItmeList.add(CategoryItem(R.drawable.category_8, "구이"))
        categoryItmeList.add(CategoryItem(R.drawable.category_9, "피자"))
        categoryItmeList.add(CategoryItem(R.drawable.category_10, "중식"))
        categoryItmeList.add(CategoryItem(R.drawable.category_11, "일식"))
        categoryItmeList.add(CategoryItem(R.drawable.category_12, "회/해물"))
        categoryItmeList.add(CategoryItem(R.drawable.category_13, "양식"))
        categoryItmeList.add(CategoryItem(R.drawable.category_14, "커피/차"))
        categoryItmeList.add(CategoryItem(R.drawable.category_15, "디저트"))
        categoryItmeList.add(CategoryItem(R.drawable.category_16, "간식"))
        categoryItmeList.add(CategoryItem(R.drawable.category_17, "아시안"))
        categoryItmeList.add(CategoryItem(R.drawable.category_18, "샌드위치"))
        categoryItmeList.add(CategoryItem(R.drawable.category_19, "샐러드"))
        categoryItmeList.add(CategoryItem(R.drawable.category_20, "버거"))
        categoryItmeList.add(CategoryItem(R.drawable.category_21, "멕시칸"))
        categoryItmeList.add(CategoryItem(R.drawable.category_22, "도시락"))
        categoryItmeList.add(CategoryItem(R.drawable.category_23, "죽"))
        categoryItmeList.add(CategoryItem(R.drawable.category_24, "프랜차이즈"))
    }

    override fun onItemClicked(position: Int) {
        showCustomToast("리사이클러뷰 $position 클릭")
    }
}