package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.*
import kotlinx.android.synthetic.main.activity_group_artist_details.*
import kotlinx.android.synthetic.main.activity_solo_artist_details.*
import kotlinx.android.synthetic.main.activity_solo_artist_details.dots_indicator


class GroupArtistDetailsActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, GroupArtistDetailsActivity::class.java)
        }
    }

    private lateinit var mGroupArtistDetailsMemberAdapter: GroupArtistDetailMemberAdapter
    private lateinit var mArtistGroupImageAdapter: ArtistGroupImageAdapter
    private lateinit var mSoloArtistVideoAdapter: SoloArtistVideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_artist_details)

        addReadMore(resources.getString(R.string.str_txt_solo_artist_about),tv_group_artist_about)

        setUpViewPagerWithIndicator()
        setUpRecyclerView()
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

    override fun finish() {
        super.finish()
       slideBackAnimation()
    }
}