package com.heinminlatt.soul_client_app.views.viewHolders

import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.item_boy_girl_artist.view.*

class ArtistGirlViewHolder(itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {

    }

    override fun bindData(data: Int) {
        itemView.iv_artist.setImageResource(
            R.drawable.aritst_girl
        )
    }


}