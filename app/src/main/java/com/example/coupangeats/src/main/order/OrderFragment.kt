package com.example.coupangeats.src.main.order

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentOrderBinding
import com.example.coupangeats.src.main.order.models.OrderListResponse
import com.example.coupangeats.src.main.order.models.OrderResult
import com.example.coupangeats.src.main.order.recyclerview.OrderRecyclerViewAdapter
import com.example.coupangeats.src.main.order.retrofit.OrderFragmentView
import com.example.coupangeats.src.main.order.retrofit.OrderService

class OrderFragment : BaseFragment<FragmentOrderBinding>(
    FragmentOrderBinding::bind,
    R.layout.fragment_order
), OrderFragmentView {

    private lateinit var orderRecyclerViewAdapter: OrderRecyclerViewAdapter
    private var orderResult = ArrayList<OrderResult>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        OrderService(this).onGetOrderList(2)



        orderRecyclerViewAdapter = OrderRecyclerViewAdapter()
        binding.recyclerviewOrder.apply {
            adapter = orderRecyclerViewAdapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }

        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("과거 준비 내역"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("준비중"))
    }

    override fun onGetOrderListSuccess(response: OrderListResponse) {
        response.result.forEach {
            orderResult.add(it)
        }
        orderRecyclerViewAdapter.submitList(orderResult)
    }

    override fun onGetOrderListFailure(message: String) {

    }
}