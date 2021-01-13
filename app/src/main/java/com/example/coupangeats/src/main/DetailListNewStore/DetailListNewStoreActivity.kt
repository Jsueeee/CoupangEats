package com.example.coupangeats.src.main.DetailListNewStore

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.config.BaseActivity
import com.example.coupangeats.databinding.ActivityDetailFranchiseBinding
import com.example.coupangeats.src.main.DetailListNewStore.models.DetailListNewStoreResult
import com.example.coupangeats.src.main.DetailListNewStore.models.Result
import com.example.coupangeats.src.main.DetailListNewStore.retrofit.DetailListNewStoreService
import com.example.coupangeats.src.main.DetailListNewStore.retrofit.DetailListNewStoreView
import com.example.coupangeats.src.main.detailListFranchise.models.DetailListResult
import com.example.coupangeats.src.main.home.decoration.MainStoreDecoration

class DetailListNewStoreActivity : BaseActivity<ActivityDetailFranchiseBinding>(
    ActivityDetailFranchiseBinding::inflate), DetailListNewStoreView{

    private var detailNewStoreItemList = ArrayList<Result>()
    private lateinit var detailListNewStoreRecyclerViewAdapter: DetailListNewStoreRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DetailListNewStoreService(this).getDetailFranchiseList()

        detailListNewStoreRecyclerViewAdapter = DetailListNewStoreRecyclerViewAdapter()
        binding.recyclerView.apply {
            adapter = detailListNewStoreRecyclerViewAdapter
            layoutManager = LinearLayoutManager(
                context, RecyclerView.VERTICAL, false
            )
            addItemDecoration(MainStoreDecoration())
        }

    }

    override fun onGetDetailNewStoreListSuccess(response: DetailListNewStoreResult) {
        response.result.forEach {
            detailNewStoreItemList.add(it)
        }
        detailListNewStoreRecyclerViewAdapter.submitList(detailNewStoreItemList)
    }

    override fun onGetDetailNewStoreListFailure(message: String) {

    }
}