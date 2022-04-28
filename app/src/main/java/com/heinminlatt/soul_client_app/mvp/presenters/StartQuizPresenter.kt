package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.delegate.ArtistScreenItemDelegate
import com.heinminlatt.soul_client_app.delegate.StartQuizScreenItemDelegate
import com.heinminlatt.soul_client_app.mvp.views.ArtistView
import com.heinminlatt.soul_client_app.mvp.views.StartQuizView

interface StartQuizPresenter : BasePresenter<StartQuizView>,StartQuizScreenItemDelegate {
    fun onUiReady()
    fun onTapAnswerButton()
    fun onTapGiveUp()
}