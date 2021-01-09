package com.example.coupangeats.src.main.address.mapSearch

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.coupangeats.R
import com.example.coupangeats.config.BaseFragment
import com.example.coupangeats.databinding.FragmentSearchAddressBinding
import com.example.coupangeats.databinding.FragmentSearchAddressSettingBinding
import com.example.coupangeats.src.main.address.map.MapActivity

class SearchAddressSettingFragment : BaseFragment<FragmentSearchAddressSettingBinding>(
    FragmentSearchAddressSettingBinding::bind,
    R.layout.fragment_search_address_setting
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearchAddressLocation.setOnClickListener {
            val intent = Intent(context, MapActivity::class.java)
            startActivity(intent)
        }
    }
}