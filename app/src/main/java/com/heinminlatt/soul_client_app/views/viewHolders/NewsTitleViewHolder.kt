package com.heinminlatt.soul_client_app.views.viewHolders

import android.util.Log
import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.delegate.HomeScreenItemDelegate
import kotlinx.android.synthetic.main.item_news_tiltle.view.*


class NewsTitleViewHolder(itemView: View, private var mDelegate: HomeScreenItemDelegate) :
    BaseViewHolder<String>(itemView) {
    override fun clickItem(it: View?) {
       // mDelegate.onTapNewsTitle()
        Log.d("","Item ")

    }

    override fun bindData(data:String) {
        mData = data
        itemView.tv_news_title.text = data
    }

}