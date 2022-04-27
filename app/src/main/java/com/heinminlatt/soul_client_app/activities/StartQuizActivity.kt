package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.shared.utils.setDivider
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.QuizQuestionAdapter
import kotlinx.android.synthetic.main.activity_scoreboard.*
import kotlinx.android.synthetic.main.activity_start_quiz.*
import kotlinx.android.synthetic.main.activity_start_quiz.iv_back


class StartQuizActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, StartQuizActivity::class.java)
        }
    }

    private lateinit var mQuizQuestionAdapter: QuizQuestionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_quiz)

        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_back.setOnClickListener {
            finish()
            slideBackAnimation()
        }
    }

    private fun setUpRecyclerView() {
        //
        rv_quiz_question.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mQuizQuestionAdapter = QuizQuestionAdapter()
        rv_quiz_question.adapter = mQuizQuestionAdapter


        mQuizQuestionAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }


    override fun onBackPressed() {
    }
}