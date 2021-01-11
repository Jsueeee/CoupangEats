package com.example.coupangeats.src.main.storeInfo.review

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.databinding.ItemReviewRecyclerviewBinding
import com.example.coupangeats.src.main.storeInfo.models.PhotoReview

class ReviewRecyclerViewHolder(val binding: ItemReviewRecyclerviewBinding): RecyclerView.ViewHolder(binding.root) {
    fun bindWithView(photoReview: PhotoReview) {

        Glide.with(ApplicationClass.instance).load(photoReview.reviewPhoto).into(binding.reviewPhoto)

        binding.reviewContent.text = photoReview.content

        when(photoReview.reviewStar){
            1 -> binding.star1.visibility = View.VISIBLE
            2 -> {
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.VISIBLE
            }
            3 -> {
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.VISIBLE
            }
            4 -> {
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.VISIBLE
                binding.star4.visibility = View.VISIBLE
            }
            5 -> {
                binding.star1.visibility = View.VISIBLE
                binding.star2.visibility = View.VISIBLE
                binding.star3.visibility = View.VISIBLE
                binding.star4.visibility = View.VISIBLE
                binding.star5.visibility = View.VISIBLE
            }
        }
    }
}