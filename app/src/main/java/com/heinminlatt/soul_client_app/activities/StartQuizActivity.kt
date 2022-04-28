package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.QuizQuestionAdapter
import com.heinminlatt.soul_client_app.dialogFragments.QuizDialogFragment
import com.heinminlatt.soul_client_app.dialogFragments.QuizDialogFragment.Companion.BUNDLE_NAME
import com.heinminlatt.soul_client_app.mvp.presenters.StartQuizPresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.StartQuizPresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.StartQuizView
import com.heinminlatt.soul_client_app.utils.GIVE_UP
import com.heinminlatt.soul_client_app.utils.RIGHT_QUIZ
import com.heinminlatt.soul_client_app.utils.TIME_UP
import com.heinminlatt.soul_client_app.utils.WRONG_QUIZ
import kotlinx.android.synthetic.main.activity_start_quiz.*
import kotlinx.android.synthetic.main.activity_start_quiz.iv_back


class StartQuizActivity : BaseActivity(),StartQuizView {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, StartQuizActivity::class.java)
        }
    }

    private lateinit var mQuizQuestionAdapter: QuizQuestionAdapter
    private lateinit var mStartQuizPresenter: StartQuizPresenter

    var rightQuizAnswer = "WonWon"
    lateinit var quizAnswer : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_quiz)

        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpPresenter() {
        mStartQuizPresenter = ViewModelProviders.of(this).get(StartQuizPresenterImpl::class.java)
        mStartQuizPresenter.initPresenter(this)
    }

    private fun setUpActionListener() {
        iv_back.setOnClickListener {
            finish()
            slideBackAnimation()
        }

        btn_answer.setOnClickListener {
            mStartQuizPresenter.onTapAnswerButton()
        }

        tv_giveUp.setOnClickListener {
            mStartQuizPresenter.onTapGiveUp()
        }
    }

    private fun setUpRecyclerView() {
        //
        rv_quiz_question.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mQuizQuestionAdapter = QuizQuestionAdapter(mStartQuizPresenter)
        rv_quiz_question.adapter = mQuizQuestionAdapter


        mQuizQuestionAdapter.setNewData(mutableListOf("The8","S.Coups","WonWon","Joshua"))
    }


    override fun onBackPressed() {
    }

    override fun displayDialogFragment() {
        if(quizAnswer == rightQuizAnswer){
            displayRightDialogFragment()
        }
        else{
            displayWrongDialogFragment()
        }
    }

    private fun displayRightDialogFragment(){
        val quizRightDialog = QuizDialogFragment.newFragment()
        val bundle = Bundle()
        bundle.putString(BUNDLE_NAME, RIGHT_QUIZ)
        quizRightDialog.arguments = bundle
        this.supportFragmentManager.let {
            quizRightDialog.show(
                it,
                QuizDialogFragment.TAG_RIGHT_DIALOG
            )
        }
    }

   private fun displayWrongDialogFragment() {
        val quizWrongDialog = QuizDialogFragment.newFragment()
        val bundle = Bundle()
        bundle.putString(BUNDLE_NAME, WRONG_QUIZ)
        quizWrongDialog.arguments = bundle
        this.supportFragmentManager.let {
            quizWrongDialog.show(
                it,
                QuizDialogFragment.TAG_RIGHT_DIALOG
            )
        }
    }

   override fun displayGiveUpDialogFragment() {
       val quizGiveUPDialog = QuizDialogFragment.newFragment()
       val bundle = Bundle()
       bundle.putString(BUNDLE_NAME, GIVE_UP)
       quizGiveUPDialog.arguments = bundle
       this.supportFragmentManager.let {
           quizGiveUPDialog.show(
               it,
               QuizDialogFragment.TAG_RIGHT_DIALOG
           )
       }
    }

   private fun displayTimeUpDialogFragment() {
       val quizTimeUpDialog = QuizDialogFragment.newFragment()
       val bundle = Bundle()
       bundle.putString(BUNDLE_NAME, TIME_UP)
       quizTimeUpDialog.arguments = bundle
       this.supportFragmentManager.let {
           quizTimeUpDialog.show(
               it,
               QuizDialogFragment.TAG_RIGHT_DIALOG
           )
       }
    }

    override fun quickQuestionAnswerStatus(answer : String) {
        quizAnswer = answer

       btn_answer.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.text_color))
        btn_answer.setTextColor(resources.getColor(R.color.white))
        btn_answer.isEnabled = true

    }

    override fun showErrorMessage(errorMessage: String) {
    }
}