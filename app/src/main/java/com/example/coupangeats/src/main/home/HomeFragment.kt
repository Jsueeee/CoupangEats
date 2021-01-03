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
    }

    override fun onItemClicked(position: Int) {
        showCustomToast("리사이클러뷰 $position 클릭")
    }
}