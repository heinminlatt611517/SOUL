package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.activity_main_quiz.*

class MainQuizActivity : BaseActivity() {
    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, MainQuizActivity::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_quiz)

        setUpActionListener()

    }

    private fun setUpActionListener() {
        iv_cancel.setOnClickListener {
            finishAffinity()
            startActivity(MainActivity.newIntent(this))
            slideTopToBottomAnimation()
        }

        btn_start_quiz.setOnClickListener {
            startActivity(StartQuizActivity.newIntent(this))
            slideToAnimation()
        }

        cv_scoreBoard.setOnClickListener {
            startActivity(ScoreboardActivity.newIntent(this))
            slideToAnimation()
        }


    }

    override fun onBackPressed() {
    }
}