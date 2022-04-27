package com.heinminlatt.soul_client_app.views.viewHolders

import android.view.View
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import kotlinx.android.synthetic.main.item_scoreboard_rank.view.*

class RankScoreBoardViewHolder(itemView: View) : BaseViewHolder<Int>(itemView) {
    override fun clickItem(it: View?) {

    }

    override fun bindData(data: Int) {
      mData = data

        itemView.tv_rank_no.text = (adapterPosition+1).toString()
    }


}