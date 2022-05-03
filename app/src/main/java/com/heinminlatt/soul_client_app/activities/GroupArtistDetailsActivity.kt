package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.*
import kotlinx.android.synthetic.main.activity_group_artist_details.*
import kotlinx.android.synthetic.main.activity_my_favourite.*
import kotlinx.android.synthetic.main.activity_solo_artist_details.dots_indicator
import kotlinx.android.synthetic.main.fragment_home.*


class GroupArtistDetailsActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, GroupArtistDetailsActivity::class.java)
        }
    }

    private lateinit var mGroupArtistDetailsMemberAdapter: GroupArtistDetailMemberAdapter
    private lateinit var mArtistGroupImageAdapter: ArtistGroupImageAdapter
    private lateinit var mSoloArtistVideoAdapter: SoloArtistVideoAdapter

    //facebook shimmer loading
    private lateinit var mBannerShimmerFrameLayout: ShimmerFrameLayout
    private lateinit var mMemberShimmerFrameLayout: ShimmerFrameLayout
    private lateinit var mGroupImageShimmerFrameLayout: ShimmerFrameLayout
    private lateinit var mVideoShimmerFrameLayout: ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_artist_details)

        addReadMore(resources.getString(R.string.str_txt_solo_artist_about),tv_group_artist_about)
        initView()
        setUpViewPagerWithIndicator()
        setUpRecyclerView()
    }

    private fun initView() {
        mBannerShimmerFrameLayout = findViewById(R.id.group_artist_detail_banner_loading)
        mMemberShimmerFrameLayout = findViewById(R.id.group_artist_detail_member_loading)
        mGroupImageShimmerFrameLayout = findViewById(R.id.group_artist_detail_group_image_loading)
        mVideoShimmerFrameLayout = findViewById(R.id.group_artist_detail_video_loading)

        showLoading()
        Handler().postDelayed({
            hideLoading()
        },4000)
    }

    private fun setUpViewPagerWithIndicator() {

        val adapter = GroupArtistViewPagerAdapter(this)
        vp_group_artist_slider.adapter = adapter
        dots_indicator.setViewPager(vp_group_artist_slider)
    }

    private fun setUpRecyclerView() {
      //member recycler view
        rv_member.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mGroupArtistDetailsMemberAdapter = GroupArtistDetailMemberAdapter()
        rv_member.adapter = mGroupArtistDetailsMemberAdapter

        mGroupArtistDetailsMemberAdapter.setNewData(mutableListOf(1, 2,3,4,5,6,7))

        //group image recycler view
        rv_groupImage.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mArtistGroupImageAdapter = ArtistGroupImageAdapter()
        rv_groupImage.adapter = mArtistGroupImageAdapter

        mArtistGroupImageAdapter.setNewData(mutableListOf(1, 2,3,4,5,6,7))

        // video recycler view
        rv_group_artist_video.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mSoloArtistVideoAdapter = SoloArtistVideoAdapter()
        rv_group_artist_video.adapter = mSoloArtistVideoAdapter

        mSoloArtistVideoAdapter.setNewData(mutableListOf(1, 2, 3,4,5,6))
    }

    private fun showLoading() {
        layout_group_artist_detail_loading.visibility = View.VISIBLE
        layout_group_artist_detail.visibility = View.GONE
        mBannerShimmerFrameLayout.startShimmer()
        mMemberShimmerFrameLayout.startShimmer()
        mGroupImageShimmerFrameLayout.startShimmer()
        mVideoShimmerFrameLayout.startShimmer()

    }

    private fun hideLoading() {
        layout_group_artist_detail_loading.visibility = View.GONE
        layout_group_artist_detail.visibility = View.VISIBLE
        mBannerShimmerFrameLayout.stopShimmer()
        mMemberShimmerFrameLayout.stopShimmer()
        mGroupImageShimmerFrameLayout.stopShimmer()
        mVideoShimmerFrameLayout.stopShimmer()
    }

    override fun finish() {
        super.finish()
       slideBackAnimation()
    }
}