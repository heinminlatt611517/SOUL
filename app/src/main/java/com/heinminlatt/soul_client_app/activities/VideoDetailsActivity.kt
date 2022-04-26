package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.NewsDetailCommentAdapter
import com.heinminlatt.soul_client_app.adapters.RelatedNewsAdapter
import com.heinminlatt.soul_client_app.adapters.RelatedVideoAdapter
import com.heinminlatt.soul_client_app.adapters.VideoDetailCommentAdapter
import kotlinx.android.synthetic.main.activity_new_details.*
import kotlinx.android.synthetic.main.activity_video_details.*

class VideoDetailsActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, VideoDetailsActivity::class.java)
        }
    }

    private lateinit var mVideoDetailCommentAdapter: VideoDetailCommentAdapter
    private lateinit var mRelatedVideoAdapter: RelatedVideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_details)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        //comment recycler view
        rv_video_detail_comment.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mVideoDetailCommentAdapter = VideoDetailCommentAdapter()
        rv_video_detail_comment.adapter = mVideoDetailCommentAdapter

        mVideoDetailCommentAdapter.setNewData(mutableListOf(1, 2))

        //related video recycler view
        rv_video_detail_related.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mRelatedVideoAdapter = RelatedVideoAdapter()
        rv_video_detail_related.adapter = mRelatedVideoAdapter

        mRelatedVideoAdapter.setNewData(mutableListOf(1, 2, 3,4,5,6))
    }

    override fun finish() {
        super.finish()
       slideBackAnimation()
    }
}