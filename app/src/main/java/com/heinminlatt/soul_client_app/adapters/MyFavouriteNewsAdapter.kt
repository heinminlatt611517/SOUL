package com.heinminlatt.soul_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.delegate.HomeScreenItemDelegate
import com.heinminlatt.soul_client_app.delegate.MyFavouriteScreenItemDelegate
import com.heinminlatt.soul_client_app.views.viewHolders.MyFavouriteNewsViewHolder
import com.heinminlatt.soul_client_app.views.viewHolders.NewsViewHolder

class MyFavouriteNewsAdapter (delegate : MyFavouriteScreenItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<Int>,Int>() {
    private val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_my_favourite_news, parent, false)
        return MyFavouriteNewsViewHolder(view,mDelegate)
    }
}