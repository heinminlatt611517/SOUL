package com.heinminlatt.soul_client_app.views.viewHolders

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.ChildSoloArtistImagesAdapter
import com.heinminlatt.soul_client_app.views.components.SpaceItemsDecoration
import kotlinx.android.synthetic.main.item_solo_artist_collection.view.*

class ParentSoloArtistCollectionViewHolder(itemView: View) : BaseViewHolder<ArrayList<Int>>(itemView) {
    override fun clickItem(it: View?) {

    }

    override fun bindData(data: ArrayList<Int>) {

        val childSoloImageAdapter = ChildSoloArtistImagesAdapter()
        itemView.rv_solo_image.layoutManager =
            GridLayoutManager(itemView.context, 3, GridLayoutManager.VERTICAL, false)
        itemView.rv_solo_image.adapter = childSoloImageAdapter
        val spacingInPixels: Unit =
        itemView.rv_solo_image.addItemDecoration(SpaceItemsDecoration(16))
        childSoloImageAdapter.setNewData(data)
    }


}