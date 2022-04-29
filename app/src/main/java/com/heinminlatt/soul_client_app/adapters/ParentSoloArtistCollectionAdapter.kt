package com.heinminlatt.soul_client_app.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.heinminlatt.shared.adapter.BaseRecyclerAdapter
import com.heinminlatt.shared.views.viewHolders.BaseViewHolder
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.views.viewHolders.*
import kotlinx.android.synthetic.main.item_solo_artist_collection.view.*

class ParentSoloArtistCollectionAdapter : BaseRecyclerAdapter<BaseViewHolder<ArrayList<Int>>, ArrayList<Int>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ArrayList<Int>> {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_solo_artist_collection, parent, false)
        return ParentSoloArtistCollectionViewHolder(view)
    }


}