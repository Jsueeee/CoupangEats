package com.example.coupangeats.src.main.order

import android.os.Bundle
import android.view.View
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentWaitingOrderBinding
import com.example.coupangeats.src.main.order.models.OrderListResponse
import com.example.coupangeats.src.main.order.retrofit.OrderFragmentView
import com.example.coupangeats.src.main.order.retrofit.OrderService

class WaitingOrderFragment: BaseFragment<FragmentWaitingOrderBinding>(FragmentWaitingOrderBinding::bind, R.layout.fragment_waiting_order), OrderFragmentView {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        OrderService(this).onGetOrderList(2)

    }

    override fun onGetOrderListSuccess(response: OrderListResponse) {

    }

    override fun onGetOrderListFailure(message: String) {

    }
}