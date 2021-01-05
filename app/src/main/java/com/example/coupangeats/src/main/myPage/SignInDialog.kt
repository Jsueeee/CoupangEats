package com.example.coupangeats.src.main.myPage

import android.app.ActionBar
import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import com.example.coupangeats.databinding.SignInDialogBinding

class SignInDialog(context: Context): Dialog(context) {

    private lateinit var binding: SignInDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //requestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = SignInDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setCanceledOnTouchOutside(true)
        setCancelable(true)
        window!!.setBackgroundDrawable(ColorDrawable())
        window!!.setGravity(Gravity.BOTTOM)
        val params: WindowManager.LayoutParams = window!!.attributes
        params.width = ActionBar.LayoutParams.MATCH_PARENT
        params.height = 900
        window!!.attributes = params
    }

    override fun show() {
        if(!this.isShowing) super.show()
    }
}