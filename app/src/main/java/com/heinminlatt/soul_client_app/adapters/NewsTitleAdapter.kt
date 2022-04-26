package com.heinminlatt.soul_client_app.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.delegate.HomeScreenItemDelegate
import com.heinminlatt.soul_client_app.views.viewHolders.NewsTitleViewHolder
import kotlinx.android.synthetic.main.item_news_tiltle.view.*


class NewsTitleAdapter (delegate: HomeScreenItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<String>,String>() {

    var mDelegate = delegate
    var rowIndex = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_tiltle, parent, false)
        return NewsTitleViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<String>, position: Int) {
        var msg = mData[position]
        holder.itemView.tv_news_title.text = msg
        holder.itemView.cv_news_title.setOnClickListener {
           rowIndex = position
            notifyDataSetChanged()
        }

        if(position==rowIndex) {
            holder.itemView.cv_news_title.setBackgroundResource(R.drawable.bg_rounded_corner_blue)
            holder.itemView.tv_news_title.setTextColor(Color.parseColor("#ffffff"))

        }
        else{
            holder.itemView.cv_news_title.setBackgroundResource(R.drawable.bg_rounded_corner)
            holder.itemView.tv_news_title.setTextColor(Color.parseColor("#A1A6AD"))
        }
        Log.d("","$msg")
    }


}