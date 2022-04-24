package com.heinminlatt.soul_client_app.views.viewHolders

import android.util.Log
import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.delegate.HomeScreenItemDelegate
import kotlinx.android.synthetic.main.item_news.view.*


class NewsViewHolder(itemView: View,private val mDelegate: HomeScreenItemDelegate) :
    BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
        // mDelegate.onTapNewsTitle()
        Log.d("", "Item ")

    }

    override fun bindData(data: Int) {
        mData = data

        itemView.cv_news.setOnClickListener{
            mDelegate.onTapNewsItem()
        }


    }

}