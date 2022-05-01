package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.ArtistSoloImageDetailAdapter
import kotlinx.android.synthetic.main.activity_artist_solo_image_detail.*
import kotlinx.android.synthetic.main.item_solo_video.*

class ArtistSoloImageDetailActivity : BaseActivity() {

    companion object {
        private const val SOLO_IMAGE_INDEX_EXTRA = "Solo Image index extra"
        fun newIntent(context: Context, soloImageIndex: Int): Intent {
            var intent = Intent(context, ArtistSoloImageDetailActivity::class.java)
            intent.putExtra(SOLO_IMAGE_INDEX_EXTRA, soloImageIndex)
            return intent
        }

    }

    private lateinit var mArtistSoloImageDetailAdapter: ArtistSoloImageDetailAdapter


    private val images = arrayOf<Int>(
            R.drawable.ic_solo_image,
            R.drawable.ic_solo_image_one,
            R.drawable.ic_solo_image,
            R.drawable.ic_solo_image_one,
            R.drawable.ic_solo_image
    )

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window?.decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
        window.statusBarColor = resources.getColor(R.color.solo_image_status_bar_color)

        setContentView(R.layout.activity_artist_solo_image_detail)

        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_back.setOnClickListener {
            finish()
            startActivity(AllSoloArtistDetailsCollectionActivity.newIntent(this))
            slideTopToBottomAnimation()
        }
    }

    private fun setUpRecyclerView() {
        // recycler view
        rv_solo_image_detail.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mArtistSoloImageDetailAdapter = ArtistSoloImageDetailAdapter()
        rv_solo_image_detail.adapter = mArtistSoloImageDetailAdapter


        (rv_solo_image_detail.layoutManager as LinearLayoutManager).
        scrollToPositionWithOffset(intent.getIntExtra(SOLO_IMAGE_INDEX_EXTRA, 0), -1)

        mArtistSoloImageDetailAdapter.notifyDataSetChanged()
        mArtistSoloImageDetailAdapter.setNewData(images.toMutableList())

    }

    override fun onBackPressed() {

    }
}

