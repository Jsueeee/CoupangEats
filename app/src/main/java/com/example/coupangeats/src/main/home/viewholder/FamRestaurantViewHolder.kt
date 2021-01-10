package com.example.coupangeats.src.main.home.viewholder

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.databinding.ItemHomeFamousRestaurantBinding
import com.example.coupangeats.src.main.home.itemInterface.FamRestaurantRecyclerViewInterface
import com.example.coupangeats.src.main.home.models.MainStore

class FamRestaurantViewHolder(
    val binding: ItemHomeFamousRestaurantBinding,
    recyclerViewInterface: FamRestaurantRecyclerViewInterface
) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    private var storeIdx: Int = 0

    private var recyclerViewInterface: FamRestaurantRecyclerViewInterface? = null

    init {
        this.recyclerViewInterface = recyclerViewInterface
        itemView.setOnClickListener(this)
    }

    fun bindWithView(famRestaurantItem: MainStore) {
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img[0])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage1)
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img[1])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage2)
        Glide.with(ApplicationClass.instance).load(famRestaurantItem.img[2])
            .placeholder(R.drawable.ic_launcher_background).into(binding.itemMainStoreImage3)
        binding.famousRestaurantTitle.text = famRestaurantItem.storeName
        binding.itemMainStoreStoreStar.text = famRestaurantItem.storeStar.toString()
        binding.itemMainStoreReviewCount.text = "(${famRestaurantItem.reviewCount})"
        binding.itemMainStoreDistance.text = famRestaurantItem.distance
        binding.itemMainStoreDeliveryFee.text = famRestaurantItem.deliveryFee

        storeIdx = famRestaurantItem.storeIdx

    }

    override fun onClick(v: View?) {
        Log.d(TAG, "FamRestaurantViewHolder - onClick() : 클릭")
        this.recyclerViewInterface?.onFamRestaurantItemClicked(storeIdx)
    }
}