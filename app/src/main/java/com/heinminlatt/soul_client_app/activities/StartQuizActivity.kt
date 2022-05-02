package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
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


class StartQuizActivity : BaseActivity(), StartQuizView {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, StartQuizActivity::class.java)
        }
    }

    private lateinit var mQuizQuestionAdapter: QuizQuestionAdapter
    private lateinit var mStartQuizPresenter: StartQuizPresenter

    var rightQuizAnswer = "WonWon"
    lateinit var quizAnswer: String
    private var timerClockAnimationHandler: Handler = Handler()
    private var timerContentHandler: Handler = Handler()

    private lateinit var timeCountDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_quiz)


        setUpPresenter()
        setUpRecyclerView()
        setUpActionListener()

        firstTimerInitializeCountDownTimer()
        init()
    }

    private fun firstTimerInitializeCountDownTimer() {
        timeCountDownTimer =
                object : CountDownTimer(16000, 1000) {
                    override fun onTick(millisUntilFinished: Long) {
                        tv_timer_count.text = (millisUntilFinished / 1000).toString()

                        if ((millisUntilFinished / 1000).toString() == "0") {
                            tv_timer_count.text = "00"
                        }
                    }
                    override fun onFinish() {
                        displayTimeUpDialogFragment()
                    }
                }
    }

    private fun init() {
        timerClockAnimationHandler.postDelayed({
            cv_timer_animation.visibility = View.GONE
            cv_timer_content.visibility = View.VISIBLE
            hideTimerContent()
        }, 3000)
    }

    private fun hideTimerContent() {
        timerContentHandler.postDelayed({
            cv_timer.visibility = View.VISIBLE
            cv_timer_content.visibility = View.GONE
            timeCountDownTimer.start()
        }, 4000)
    }

    private fun setUpPresenter() {
        mStartQuizPresenter = ViewModelProviders.of(this).get(StartQuizPresenterImpl::class.java)
        mStartQuizPresenter.initPresenter(this)
    }

    private fun setUpActionListener() {
        iv_back.setOnClickListener {
            finishAffinity()
            startActivity(MainQuizActivity.newIntent(this))
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


        mQuizQuestionAdapter.setNewData(mutableListOf("The8", "S.Coups", "WonWon", "Joshua"))
    }


    override fun onBackPressed() {
    }

    override fun displayDialogFragment() {
        if (quizAnswer == rightQuizAnswer) {
            displayRightDialogFragment()
        } else {
            displayWrongDialogFragment()

        }
    }

    private fun displayRightDialogFragment() {
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

    override fun quickQuestionAnswerStatus(answer: String) {
        quizAnswer = answer

        btn_answer.backgroundTintList = ColorStateList.valueOf(resources.getColor(R.color.text_color))
        btn_answer.setTextColor(resources.getColor(R.color.white))
        btn_answer.isEnabled = true
        stopClockHandler()

    }


    private fun stopClockHandler() {
        cv_timer.visibility = View.GONE
        cv_timer_content.visibility = View.GONE
        cv_timer_animation.visibility = View.GONE

        timerClockAnimationHandler.removeMessages(0)
        timerContentHandler.removeMessages(0)
        timeCountDownTimer.cancel()
    }

    override fun showErrorMessage(errorMessage: String) {
    }
}