package com.heinminlatt.soul_client_app.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface SoloArtistDetailView : BaseView {
    fun navigateToArtistSoloImageDetailScreen(soloImageItemIndex : Int)
}