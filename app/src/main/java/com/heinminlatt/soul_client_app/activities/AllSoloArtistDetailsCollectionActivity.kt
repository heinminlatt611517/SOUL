package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.ParentSoloArtistCollectionAdapter
import com.heinminlatt.soul_client_app.views.components.CustomLinearLayoutManager
import kotlinx.android.synthetic.main.activity_all_solo_artist_details_activty.*
import kotlinx.android.synthetic.main.activity_all_solo_artist_details_activty.iv_back
import kotlinx.android.synthetic.main.activity_artist_solo_image_detail.*

class AllSoloArtistDetailsCollectionActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, AllSoloArtistDetailsCollectionActivity::class.java)
        }
    }

    private lateinit var mAllSoloArtistCollectionAdapter: ParentSoloArtistCollectionAdapter
    var mParentDataList  = arrayListOf(
        arrayListOf(1,2), arrayListOf(4,5,6,5), arrayListOf(7,8,9),
        arrayListOf(1,4,7,5,5), arrayListOf(2,5,8,5),
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_solo_artist_details_activty)

        setUpRecyclerView()
        setUpActionListener()

    }

    private fun setUpActionListener() {
        iv_back.setOnClickListener {
            finish()
            startActivity(SoloArtistDetailsActivity.newIntent(this))
            slideBackAnimation()
        }
    }

    private fun setUpRecyclerView() {
        // rank scoreboard recycler
        rv_all_solo_artist_collection.layoutManager =
            CustomLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAllSoloArtistCollectionAdapter = ParentSoloArtistCollectionAdapter()
        rv_all_solo_artist_collection.adapter = mAllSoloArtistCollectionAdapter

        mAllSoloArtistCollectionAdapter.setNewData(mParentDataList.toMutableList())

    }

    override fun onBackPressed() {

    }
}