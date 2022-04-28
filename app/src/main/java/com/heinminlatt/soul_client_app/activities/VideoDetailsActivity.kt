package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.RelatedVideoAdapter
import com.heinminlatt.soul_client_app.bottomSheetDialogFragments.VideoCommentBottomSheetFragment
import kotlinx.android.synthetic.main.activity_video_details.*

class VideoDetailsActivity : BaseActivity() {

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, VideoDetailsActivity::class.java)
        }
    }


    private lateinit var mRelatedVideoAdapter: RelatedVideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_details)

        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_viewMoreCommentData.setOnClickListener {
            val bottomSheetDialogFragment= VideoCommentBottomSheetFragment()
            this.supportFragmentManager.let { it -> bottomSheetDialogFragment.show(
                    it,
                    bottomSheetDialogFragment.tag
            )
            }
        }
    }

    private fun setUpRecyclerView() {
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