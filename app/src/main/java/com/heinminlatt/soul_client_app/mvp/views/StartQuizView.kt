package com.heinminlatt.soul_client_app.mvp.views

import com.heinminlatt.shared.mvp.view.BaseView

interface StartQuizView : BaseView{
    fun displayDialogFragment()
    fun quickQuestionAnswerStatus(answer : String)
    fun displayGiveUpDialogFragment()

}