package com.example.coupangeats.src.main.detailListFranchise

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityDetailFranchiseBinding
import com.example.coupangeats.src.main.detailListFranchise.models.DetailListResult
import com.example.coupangeats.src.main.detailListFranchise.models.Result
import com.example.coupangeats.src.main.detailListFranchise.retrofit.DetailFranchiseService
import com.example.coupangeats.src.main.detailListFranchise.retrofit.DetailFranchiseView
import com.example.coupangeats.src.main.home.decoration.MainStoreDecoration

class DetailFranchiseActivity: BaseActivity<ActivityDetailFranchiseBinding>(ActivityDetailFranchiseBinding::inflate), DetailFranchiseView{

    private var detailFranchiseItemList = ArrayList<Result>()
    private lateinit var detailFranchiseRecyclerViewAdapter: DetailFranchiseRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DetailFranchiseService(this).getDetailFranchiseList()

        detailFranchiseRecyclerViewAdapter = DetailFranchiseRecyclerViewAdapter()
        binding.recyclerView.apply{
            adapter = detailFranchiseRecyclerViewAdapter
            layoutManager = LinearLayoutManager(
                context, RecyclerView.VERTICAL, false
            )
            addItemDecoration(MainStoreDecoration())
        }


    }

    override fun onGetDetailFranchiseListSuccess(response: DetailListResult) {
        response.result.forEach {
            detailFranchiseItemList.add(it)
        }

        detailFranchiseRecyclerViewAdapter.submitList(detailFranchiseItemList)
    }

    override fun onGetDetailFranchiseListFailure(message: String) {

    }
}