package com.heinminlatt.soul_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.delegate.VideoScreenItemDelegate
import com.heinminlatt.soul_client_app.views.viewHolders.NewsViewHolder
import com.heinminlatt.soul_client_app.views.viewHolders.SoloArtistViewHolder
import com.heinminlatt.soul_client_app.views.viewHolders.TopVideoViewHolder

class TopVideoAdapter(delegate : VideoScreenItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<Int>,Int>() {
    private val mDelegate = delegate
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_top_video, parent, false)
        return TopVideoViewHolder(view,mDelegate)
    }
}