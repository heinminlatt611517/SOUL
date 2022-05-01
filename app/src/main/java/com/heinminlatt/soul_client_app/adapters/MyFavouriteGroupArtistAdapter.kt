package com.heinminlatt.soul_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.delegate.HomeScreenItemDelegate
import com.heinminlatt.soul_client_app.delegate.MyFavouriteScreenItemDelegate
import com.heinminlatt.soul_client_app.views.viewHolders.MyFavouriteGroupArtistViewHolder
import com.heinminlatt.soul_client_app.views.viewHolders.MyFavouriteNewsViewHolder
import com.heinminlatt.soul_client_app.views.viewHolders.NewsViewHolder

class MyFavouriteGroupArtistAdapter: BaseRecyclerAdapter<BaseViewHolder<Int>,Int>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_my_favourite_group_artist, parent, false)
        return MyFavouriteGroupArtistViewHolder(view)
    }
}