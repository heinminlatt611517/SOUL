package com.heinminlatt.soul_client_app.views.viewHolders

import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.delegate.HomeScreenItemDelegate
import kotlinx.android.synthetic.main.item_solo_artist.view.*

class SoloArtistViewHolder(itemView: View,private val mDelegate : HomeScreenItemDelegate) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {

    }

    override fun bindData(data: Int) {
      mData = data
        itemView.cv_home_solo_artist.setOnClickListener {
            mDelegate.onTapSoloArtistItem()
        }
    }


}