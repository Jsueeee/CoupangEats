package com.example.coupangeats.src.main.address.mapSearch.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass.Companion.TAG
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentSearchAddressKeywordBinding
import com.example.coupangeats.src.main.address.mapSearch.recyclerview.SearchAddressRecyclerviewAdapter
import com.example.coupangeats.src.main.address.models.SearchRecyclerViewResult

class SearchAddressKeywordFragment(searchResult: ArrayList<SearchRecyclerViewResult>) : BaseFragment<FragmentSearchAddressKeywordBinding>(
    FragmentSearchAddressKeywordBinding::bind,
    R.layout.fragment_search_address_keyword
) {

    private val searchResultItemList: ArrayList<SearchRecyclerViewResult> = searchResult
    private lateinit var searchAddressRecyclerviewAdapter: SearchAddressRecyclerviewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchAddressRecyclerviewAdapter = SearchAddressRecyclerviewAdapter(context!!)
        binding.recyclerViewSearchAddress.apply {
            adapter = searchAddressRecyclerviewAdapter
            layoutManager = LinearLayoutManager(
                context, RecyclerView.VERTICAL, false
            )
        }

        searchAddressRecyclerviewAdapter.submitList(searchResultItemList)
    }

}