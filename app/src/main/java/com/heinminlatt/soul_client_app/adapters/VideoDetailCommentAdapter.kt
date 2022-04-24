package com.heinminlatt.soul_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.views.viewHolders.AllGirlGroupViewHolder
import com.heinminlatt.soul_client_app.views.viewHolders.ArtistBoyViewHolder
import com.heinminlatt.soul_client_app.views.viewHolders.SoloArtistViewHolder

class VideoDetailCommentAdapter : BaseRecyclerAdapter<BaseViewHolder<Int>,Int>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_detail_comment, parent, false)
        return AllGirlGroupViewHolder(view)
    }
}