package com.heinminlatt.soul_client_app.views.viewHolders

import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import kotlinx.android.synthetic.main.item_solo_image_detail.view.*

class ArtistSoloImageDetailViewHolder(itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {

    }

    override fun bindData(data: Int) {
      mData = data
        itemView.iv_solo_image_detail.setImageResource(data)
    }


}