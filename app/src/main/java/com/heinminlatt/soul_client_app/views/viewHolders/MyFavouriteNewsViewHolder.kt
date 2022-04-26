package com.heinminlatt.soul_client_app.views.viewHolders

import android.util.Log
import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.delegate.HomeScreenItemDelegate
import com.heinminlatt.soul_client_app.delegate.MyFavouriteScreenItemDelegate
import kotlinx.android.synthetic.main.item_news.view.*


class MyFavouriteNewsViewHolder(itemView: View, private val mDelegate: MyFavouriteScreenItemDelegate) :
    BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {
        // mDelegate.onTapNewsTitle()
        Log.d("", "Item ")

    }

    override fun bindData(data: Int) {
        mData = data
        itemView.cv_news.setBackgroundResource(R.color.app_color)

    }

}