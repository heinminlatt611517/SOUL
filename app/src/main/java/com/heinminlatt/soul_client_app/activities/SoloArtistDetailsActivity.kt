package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.SoloArtistVideoAdapter
import com.heinminlatt.soul_client_app.adapters.SoloArtistViewPagerAdapter
import com.heinminlatt.soul_client_app.adapters.SoloImageAdapter
import com.heinminlatt.soul_client_app.mvp.presenters.SoloArtistDetailPresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.SoloArtistDetailPresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.SoloArtistDetailView
import kotlinx.android.synthetic.main.activity_artist_solo_image_detail.*
import kotlinx.android.synthetic.main.activity_solo_artist_details.*
import kotlinx.android.synthetic.main.activity_solo_artist_details.dots_indicator
import kotlinx.android.synthetic.main.artist_solo_image_layout.*


class SoloArtistDetailsActivity : BaseActivity(),SoloArtistDetailView {

     companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, SoloArtistDetailsActivity::class.java)
        }
    }

    private lateinit var mSoloImageAdapter: SoloImageAdapter
    private lateinit var mSoloArtistVideoAdapter: SoloArtistVideoAdapter

    //presenter
    private lateinit var mPresenter : SoloArtistDetailPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solo_artist_details)

        addReadMore(resources.getString(R.string.str_txt_solo_artist_about),tv_solo_artist_about)

        setUpPresenter()
        setUpViewPagerWithIndicator()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(SoloArtistDetailPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpActionListener() {
        iv_viewMore_soloImage.setOnClickListener {
            finish()
            startActivity(AllSoloArtistDetailsCollectionActivity.newIntent(this))
            slideToAnimation()
        }

        iv_back_from_detail.setOnClickListener {
            finish()
            slideBackAnimation()
        }
    }

    private fun setUpViewPagerWithIndicator() {

        val adapter = SoloArtistViewPagerAdapter(this)
        vp_solo_artist_slider.adapter = adapter
        dots_indicator.setViewPager(vp_solo_artist_slider)
    }
    private fun setUpRecyclerView() {
        //solo image recycler view
        rv_solo_image.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mSoloImageAdapter = SoloImageAdapter(mPresenter)
        rv_solo_image.adapter = mSoloImageAdapter

        mSoloImageAdapter.setNewData(mutableListOf(1, 2,3,4,5,6,7))

        // video recycler view
        rv_video.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mSoloArtistVideoAdapter = SoloArtistVideoAdapter()
        rv_video.adapter = mSoloArtistVideoAdapter

        mSoloArtistVideoAdapter.setNewData(mutableListOf(1, 2, 3,4,5,6))
    }

    override fun navigateToArtistSoloImageDetailScreen() {
        finish()
        startActivity(ArtistSoloImageDetailActivity.newIntent(this))
        slideBottomToTopAnimation()
    }

    override fun showErrorMessage(errorMessage: String) {

    }


}