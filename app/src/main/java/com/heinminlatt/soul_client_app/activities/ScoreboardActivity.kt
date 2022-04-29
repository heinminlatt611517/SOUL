package com.heinminlatt.soul_client_app.activities
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.shared.utils.setDivider
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.RankScoreBoardAdapter
import com.heinminlatt.soul_client_app.adapters.ScoreBoardWinnerTitleAdapter
import com.heinminlatt.soul_client_app.views.components.CustomLinearLayoutManager
import kotlinx.android.synthetic.main.activity_scoreboard.*


class ScoreboardActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ScoreboardActivity::class.java)
        }
    }

    private lateinit var mRankScoreBoardAdapter: RankScoreBoardAdapter
    private lateinit var mScoreBoardWinnerTitleAdapter: ScoreBoardWinnerTitleAdapter
    val speedScroll = 2000
    val handler: Handler = Handler()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = Color.TRANSPARENT

        setContentView(R.layout.activity_scoreboard)
        setUpRecyclerView()
        setUpActionListener()


    }

    private fun setUpActionListener() {
        iv_back.setOnClickListener {
            startActivity(MainQuizActivity.newIntent(this))
            slideBackAnimation()
            finish()
        }
    }

    private fun setUpRecyclerView() {
        // rank scoreboard recycler
        rv_scoreboardWinner.layoutManager =
            CustomLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mScoreBoardWinnerTitleAdapter = ScoreBoardWinnerTitleAdapter()
        rv_scoreboardWinner.adapter = mScoreBoardWinnerTitleAdapter
        mScoreBoardWinnerTitleAdapter.setNewData(mutableListOf(1, 2, 3, 5))
        handleAutoScroll()



        // rank scoreboard recycler
        rv_scoreBoard.layoutManager =
            CustomLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRankScoreBoardAdapter = RankScoreBoardAdapter()
        rv_scoreBoard.adapter = mRankScoreBoardAdapter
        rv_scoreBoard.setDivider(R.drawable.recycler_divider)

        mRankScoreBoardAdapter.setNewData(mutableListOf(1, 2, 3, 5, 6, 7, 7, 8))

    }

    private fun handleAutoScroll(){
        val runnable: Runnable = object : Runnable {
            var count = 0
            var flag = true
            override fun run() {
                if (count < mScoreBoardWinnerTitleAdapter.itemCount) {
                    if (count == mScoreBoardWinnerTitleAdapter.itemCount - 1) {
                        flag = false
                    } else if (count == 0) {
                        flag = true
                    }

                    if (flag) {
                        count++
                    } else {
                        count = 0
                    }
                    rv_scoreboardWinner.smoothScrollToPosition(count)
                    handler.postDelayed(this, speedScroll.toLong())
                }
            }
        }

        handler.postDelayed(runnable, speedScroll.toLong())
    }


    override fun onBackPressed() {
    }
}