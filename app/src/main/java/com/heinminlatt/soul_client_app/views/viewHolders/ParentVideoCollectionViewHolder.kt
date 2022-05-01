package com.heinminlatt.soul_client_app.views.viewHolders

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.adapters.ChildVideoCollectionAdapter
import com.heinminlatt.soul_client_app.views.components.SpaceItemsDecoration
import kotlinx.android.synthetic.main.item_parent_video_collection.view.*

class ParentVideoCollectionViewHolder(itemView: View) : BaseViewHolder<ArrayList<Int>>(itemView) {
    override fun clickItem(it: View?) {

    }

    override fun bindData(data: ArrayList<Int>) {

        val mChildVideoCollectionAdapter = ChildVideoCollectionAdapter()
        itemView.rv_child_video_collection.layoutManager =
            GridLayoutManager(itemView.context, 2, GridLayoutManager.VERTICAL, false)
        itemView.rv_child_video_collection.adapter = mChildVideoCollectionAdapter
        val spacingInPixels: Unit =
        itemView.rv_child_video_collection.addItemDecoration(SpaceItemsDecoration(16))
        mChildVideoCollectionAdapter.setNewData(data)
    }


}