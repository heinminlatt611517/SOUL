package com.heinminlatt.soul_client_app.views.components

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(private val margin: Int,private val columns : Int) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        var position = parent.getChildLayoutPosition(view)
        //set right margin to all
        outRect.right = margin
        //set bottom margin to all
        outRect.bottom = margin;
        //we only add top margin to the first row
        if (position <columns) {
            outRect.top = margin;
        }
        //add left margin only to the first column
        if(position%columns==0){
            outRect.left = margin;
        }

    }
}