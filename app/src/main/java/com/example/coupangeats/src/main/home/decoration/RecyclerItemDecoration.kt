package com.example.coupangeats.src.main.home.decoration

import android.content.Context
import android.graphics.Rect
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.coupangeats.R
import com.example.coupangeats.config.ApplicationClass
import com.example.coupangeats.config.ApplicationClass.Companion.TAG

class RecyclerItemDecoration: RecyclerView.ItemDecoration() {
    private var size10 = 0
    private var size20 = 0

    init{
        size10 =  dpToPx(ApplicationClass.instance, 10)
        size20 =  dpToPx(ApplicationClass.instance, 20)
    }
    fun dpToPx(context: Context, dp: Int): Int{
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics
        ).toInt()
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        var position = parent.getChildAdapterPosition(view)
        Log.d(TAG, "RecyclerItemDecoration - getItemOffsets() : position / $position")
        var itemCount = state.itemCount
        Log.d(TAG, "RecyclerItemDecoration - getItemOffsets() : itemCount / $itemCount")


        when (position) {
            0 -> {
                outRect.left = size20
            }
            itemCount-1 -> {
                outRect.left = size10
                outRect.right = size20
            }
            else -> {
                outRect.left = size10
            }
        }
    }
}
