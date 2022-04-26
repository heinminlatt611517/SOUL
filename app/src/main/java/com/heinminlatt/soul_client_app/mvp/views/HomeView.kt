package com.heinminlatt.soul_client_app.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface HomeView : BaseView {
    fun navigateToNewsDetailScreen()
    fun navigateToSoloArtistDetailScreen()
    fun navigateToSearchScreen()
}