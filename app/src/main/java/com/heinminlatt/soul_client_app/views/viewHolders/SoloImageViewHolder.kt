package com.heinminlatt.soul_client_app.views.viewHolders

import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.delegate.SoloArtistDetailScreenItemDelegate
import kotlinx.android.synthetic.main.item_solo_artist.view.*
import kotlinx.android.synthetic.main.item_solo_image.view.*

class SoloImageViewHolder(itemView: View,private val mDelegate : SoloArtistDetailScreenItemDelegate) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {

    }

    override fun bindData(data: Int) {
     mData = data
        itemView.iv_solo_image.setOnClickListener {
            mDelegate.onTapSoloImageItem(adapterPosition)
        }

        itemView.iv_solo_image.setImageResource(data)
    }


}