package com.heinminlatt.soul_client_app.mvp.presenters

import com.heinminlatt.shared.mvp.presenter.BasePresenter
import com.heinminlatt.soul_client_app.delegate.HomeScreenItemDelegate
import com.heinminlatt.soul_client_app.mvp.views.SearchNewsView

interface SearchNewsPresenter : BasePresenter<SearchNewsView>,HomeScreenItemDelegate {
}