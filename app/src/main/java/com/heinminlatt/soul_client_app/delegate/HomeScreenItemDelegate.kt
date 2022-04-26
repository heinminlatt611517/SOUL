package com.heinminlatt.soul_client_app.delegate

import com.heinminlatt.soul_client_app.views.viewPods.ReactionViewPod

interface HomeScreenItemDelegate : ReactionViewPod.Delegate{
    fun onTapNewsItem()
    fun onTapSoloArtistItem()
}