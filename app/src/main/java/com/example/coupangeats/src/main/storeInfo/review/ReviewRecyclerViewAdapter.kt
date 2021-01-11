package com.example.coupangeats.src.main.storeInfo.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.databinding.ItemReviewRecyclerviewBinding
import com.example.coupangeats.src.main.storeInfo.models.PhotoReview

class ReviewRecyclerViewAdapter: RecyclerView.Adapter<ReviewRecyclerViewHolder>() {

    private var reviewItemList = ArrayList<PhotoReview>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewRecyclerViewHolder {
        return ReviewRecyclerViewHolder(
            ItemReviewRecyclerviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ReviewRecyclerViewHolder, position: Int) {
        holder.bindWithView(reviewItemList[position])
    }

    override fun getItemCount(): Int {
        return reviewItemList.size
    }

    fun submitList(reviewItemList: ArrayList<PhotoReview>){
        this.reviewItemList = reviewItemList
        notifyDataSetChanged()
    }
}