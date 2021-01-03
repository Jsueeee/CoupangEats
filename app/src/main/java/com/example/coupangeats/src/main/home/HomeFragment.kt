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
import com.example.coupangeats.src.main.home.models.FamRestaurantItem
import com.example.coupangeats.src.main.home.models.FranchiseItem
import com.example.coupangeats.src.main.home.models.PageItem

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home),
    HomeFragmentView, CategoryRecyclerViewInterface {

    private var pageItemList = ArrayList<PageItem>()
    private lateinit var topViewPagerAdapter: TopViewPagerAdapter

    private var categoryItemList = ArrayList<CategoryItem>()
    private lateinit var categoryRecyclerViewAdapter: CategoryRecyclerViewAdapter

    private var franchiseItemList = ArrayList<FranchiseItem>()
    private lateinit var franchiseRecyclerViewAdapter: FranchiseRecyclerViewAdapter

    private var famRestaurantItemList = ArrayList<FamRestaurantItem>()
    private lateinit var famRestaurantRecyclerViewAdapter: FamRestaurantRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pageItemList.add(PageItem(R.drawable.item_main1.toString()))
        pageItemList.add(PageItem(R.drawable.item_main2.toString()))

        topViewPagerAdapter = TopViewPagerAdapter(pageItemList)

        binding.homeTopViewpager.apply {
            adapter = topViewPagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }

        addCategoryItem()
        categoryRecyclerViewAdapter = CategoryRecyclerViewAdapter(this)

        categoryRecyclerViewAdapter.submitList(categoryItemList)
        binding.recyclerviewHomeMenuCategory.apply {
            adapter = categoryRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }

        franchiseRecyclerViewAdapter = FranchiseRecyclerViewAdapter()

        franchiseItemList.add(FranchiseItem(R.drawable.ic_launcher_background.toString(), "1인분"))
        franchiseItemList.add(FranchiseItem(R.drawable.ic_launcher_background.toString(), "1인분"))
        franchiseRecyclerViewAdapter.submitList(franchiseItemList)
        binding.recyclerViewFranchise.apply {
            adapter = franchiseRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        }

        famRestaurantRecyclerViewAdapter = FamRestaurantRecyclerViewAdapter()

        famRestaurantItemList.add(FamRestaurantItem(R.drawable.ic_launcher_background.toString(), "1인분"))
        famRestaurantItemList.add(FamRestaurantItem(R.drawable.ic_launcher_background.toString(), "1인분"))
        famRestaurantRecyclerViewAdapter.submitList(famRestaurantItemList)
        binding.recyclerViewFamousRestaurant.apply {
            adapter = famRestaurantRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false
            )
        }
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
        showCustomToast("리사이클러뷰 $position 클릭")
    }
}