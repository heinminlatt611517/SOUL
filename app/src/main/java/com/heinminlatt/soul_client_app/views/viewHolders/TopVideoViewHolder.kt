package com.heinminlatt.soul_client_app.views.viewHolders

import android.util.Log
import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.delegate.VideoScreenItemDelegate
import kotlinx.android.synthetic.main.item_top_video.view.*


class TopVideoViewHolder(itemView: View,private val mDelegate : VideoScreenItemDelegate) :
    BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
        // mDelegate.onTapNewsTitle()
        Log.d("", "Item ")

    }

    override fun bindData(data: Int) {
        mData = data
        itemView.cv_topVideo.setOnClickListener {
            mDelegate.onTapTopVideoItem()
        }

    }

}