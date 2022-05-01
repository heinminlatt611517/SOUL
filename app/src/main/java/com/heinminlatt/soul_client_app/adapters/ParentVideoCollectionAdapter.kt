package com.heinminlatt.soul_client_app.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.views.viewHolders.*

class ParentVideoCollectionAdapter : BaseRecyclerAdapter<BaseViewHolder<ArrayList<Int>>, ArrayList<Int>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ArrayList<Int>> {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_parent_video_collection, parent, false)
        return ParentVideoCollectionViewHolder(view)
    }


}