package com.example.coupangeats.src.main.home

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentHomeBinding
import com.example.coupangeats.src.main.home.models.PageItem

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView {

    private var pageItemList = ArrayList<PageItem>()
    private lateinit var topViewPagerAdapter: TopViewPagerAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pageItemList.add(PageItem(R.drawable.item_main1.toString()))
        pageItemList.add(PageItem(R.drawable.item_main2.toString()))

        topViewPagerAdapter = TopViewPagerAdapter(pageItemList)

        binding.homeTopViewpager.apply{
            adapter = topViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
    }
}