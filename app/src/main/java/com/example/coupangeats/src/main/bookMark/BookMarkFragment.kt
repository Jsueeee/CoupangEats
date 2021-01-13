package com.example.coupangeats.src.main.bookMark

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentBookmarkBinding
import com.example.coupangeats.src.main.bookMark.models.HeartStore
import com.example.coupangeats.src.main.bookMark.models.MyBookMarkList
import com.example.coupangeats.src.main.bookMark.recyclerview.BookMarkRecyclerViewAdapter

class BookMarkFragment : BaseFragment<FragmentBookmarkBinding>(
    FragmentBookmarkBinding::bind,
    R.layout.fragment_bookmark
), BookMarkFragmentView {

    private var bookMarkList = ArrayList<HeartStore>()
    private lateinit var bookMarkRecyclerviewAdapter: BookMarkRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bookMarkRecyclerviewAdapter = BookMarkRecyclerViewAdapter()
        binding.recyclerViewFramgentBookmark.apply {
            adapter = bookMarkRecyclerviewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        BookMarkService(this).getBookMarkList()

    }

    override fun onGetBookMarkListSuccess(response: MyBookMarkList) {
        if(response.heartStore == null){
            showCustomToast("즐겨찾기 목록이 없습니다.")
        }
        else{
            binding.totalCount.text = "총 ${response.heartCount}개"
            response.heartStore.forEach {
                bookMarkList.add(it)
            }
        }
        bookMarkRecyclerviewAdapter.submitList(bookMarkList)
    }

    override fun onGetBookMarkListFailure(message: String) {

    }


}