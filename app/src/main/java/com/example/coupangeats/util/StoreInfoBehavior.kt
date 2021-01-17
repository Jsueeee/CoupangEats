package com.example.coupangeats.util

import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat

class StoreInfoBehavior: CoordinatorLayout.Behavior<View>() {
    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        axes: Int
    ): Boolean {



        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }
}