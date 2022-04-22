package com.heinminlatt.soul_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.views.viewHolders.TopNewsViewHolder

class TopNewsAdapter : BaseRecyclerAdapter<BaseViewHolder<Int>,Int>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Int> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_top_news, parent, false)
        return TopNewsViewHolder(view)
    }
}