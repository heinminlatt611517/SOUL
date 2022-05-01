package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.delegate.VideoScreenItemDelegate
import com.heinminlatt.soul_client_app.mvp.views.SearchVideoVIew

interface SearchVideoPresenter : BasePresenter<SearchVideoVIew>,VideoScreenItemDelegate {
}