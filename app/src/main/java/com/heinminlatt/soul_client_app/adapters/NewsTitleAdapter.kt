package com.heinminlatt.soul_client_app.adapters

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.delegate.HomeNewsTitleItemDelegate
import com.heinminlatt.soul_client_app.views.viewHolders.NewsTitleViewHolder
import kotlinx.android.synthetic.main.item_news_tiltle.view.*


class NewsTitleAdapter (delegate: HomeNewsTitleItemDelegate) : BaseRecyclerAdapter<BaseViewHolder<String>,String>() {

    var mDelegate = delegate
    var row_index = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<String> {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_news_tiltle, parent, false)
        return NewsTitleViewHolder(view,mDelegate)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<String>, position: Int) {
        var msg = mData[position]
        holder.itemView.tv_news_title.text = msg;
        holder.itemView.cv_news_title.setOnClickListener {
           row_index = position
            notifyDataSetChanged()
        }

        if(position==row_index) {
            holder.itemView.cv_news_title.setBackgroundColor(Color.parseColor("#2CB9C1"))
            holder.itemView.tv_news_title.setTextColor(Color.parseColor("#ffffff"))
        }
        else{
            holder.itemView.cv_news_title.setBackgroundColor(Color.parseColor("#F7F7F7"))
            holder.itemView.tv_news_title.setTextColor(Color.parseColor("#A1A6AD"))
        }
        Log.d("","$msg")
    }


}