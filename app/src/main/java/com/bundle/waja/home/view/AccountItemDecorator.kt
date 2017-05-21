package com.bundle.waja.home.view

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.view.View

class AccountItemDecoration : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val position = parent.getChildAdapterPosition(view)

        if (position == 0 || position == 1) {
            outRect.top = 8.dpToPx(parent.resources.displayMetrics)
        } else {
            outRect.top = 4.dpToPx(parent.resources.displayMetrics)
        }

        outRect.bottom = 4.dpToPx(parent.resources.displayMetrics)


        if (position.rem(2) == 0) {
            outRect.right = 4.dpToPx(parent.resources.displayMetrics)
            outRect.left = 8.dpToPx(parent.resources.displayMetrics)
        } else {
            outRect.right = 8.dpToPx(parent.resources.displayMetrics)
            outRect.left = 4.dpToPx(parent.resources.displayMetrics)
        }
    }
}

fun Float.dpToPx(displayMetrics: DisplayMetrics) = this * displayMetrics.density
fun Int.dpToPx(displayMetrics: DisplayMetrics) = this.toFloat().dpToPx(displayMetrics).toInt()

