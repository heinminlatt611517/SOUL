package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.NewsDetailCommentAdapter
import com.heinminlatt.soul_client_app.adapters.RelatedNewsAdapter
import kotlinx.android.synthetic.main.activity_new_details.*

class NewDetailsActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, NewDetailsActivity::class.java)
        }
    }


    private lateinit var mNewsDetailCommentAdapter: NewsDetailCommentAdapter
    private lateinit var mRelatedNewsAdapter: RelatedNewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_details)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        //comment recycler view
        rv_news_detail_comment.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mNewsDetailCommentAdapter = NewsDetailCommentAdapter()
        rv_news_detail_comment.adapter = mNewsDetailCommentAdapter

        mNewsDetailCommentAdapter.setNewData(mutableListOf(1, 2))

        //related news recycler view
        rv_news_detail_related.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRelatedNewsAdapter = RelatedNewsAdapter()
        rv_news_detail_related.adapter = mRelatedNewsAdapter

        mRelatedNewsAdapter.setNewData(mutableListOf(1, 2, 3,4,5,6))
    }

    override fun finish() {
        super.finish()
       slideBackAnimation()
    }
}