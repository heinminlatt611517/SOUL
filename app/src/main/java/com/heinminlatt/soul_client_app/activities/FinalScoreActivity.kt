package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.activity_final_score.*
import kotlinx.android.synthetic.main.view_pod_empty.*

class FinalScoreActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, FinalScoreActivity::class.java)
        }
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = resources.getColor(R.color.color_main_black)

        setContentView(R.layout.activity_final_score)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        btn_exitQuiz.setOnClickListener {
            finishAffinity()
            startActivity(MainQuizActivity.newIntent(this))
            slideBackAnimation()
        }

        cv_tryAgain.setOnClickListener {
            startActivity(StartQuizActivity.newIntent(this))
            slideBackAnimation()
            finish()
        }

        cv_scoreBoard.setOnClickListener {
            startActivity(ScoreboardActivity.newIntent(this))
            slideToAnimation()
            finish()
        }

        iv_back.setOnClickListener {
            startActivity(StartQuizActivity.newIntent(this))
            slideBackAnimation()
            finish()
        }


    }

    override fun onBackPressed() {

    }
}