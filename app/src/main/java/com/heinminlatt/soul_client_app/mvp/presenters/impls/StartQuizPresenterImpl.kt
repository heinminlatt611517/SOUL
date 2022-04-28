package com.heinminlatt.soul_client_app.mvp.presenters.impls

import com.heinminlatt.shared.mvp.presenter.AbstractBasePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.StartQuizPresenter
import com.heinminlatt.soul_client_app.mvp.views.StartQuizView

class StartQuizPresenterImpl : StartQuizPresenter,AbstractBasePresenter<StartQuizView>() {
    override fun onUiReady() {

    }

    override fun onTapAnswerButton() {
        mView?.displayDialogFragment()
    }

    override fun onTapGiveUp() {
        mView?.displayGiveUpDialogFragment()
    }

    override fun onTapQuizQuestionItem(answer : String) {
        mView?.quickQuestionAnswerStatus(answer)
    }
}