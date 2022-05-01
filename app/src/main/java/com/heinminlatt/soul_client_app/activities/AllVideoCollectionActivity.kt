package com.heinminlatt.soul_client_app.activities


import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.ParentVideoCollectionAdapter
import com.heinminlatt.soul_client_app.views.components.CustomLinearLayoutManager
import kotlinx.android.synthetic.main.activity_all_video_collection.*

class AllVideoCollectionActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, AllVideoCollectionActivity::class.java)
        }
    }
    var mParentDataList  = arrayListOf(
        arrayListOf(1,2), arrayListOf(4,5,6,5), arrayListOf(7,8,9),
        arrayListOf(1,4,7,5,5), arrayListOf(2,5,8,5),
    )


    private lateinit var mParentVideoCollectionAdapter: ParentVideoCollectionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_video_collection)

        setUpRecyclerView()

        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_back.setOnClickListener {
            finish()
            slideBackAnimation()
        }
    }

    private fun setUpRecyclerView() {

        rv_parent_video_collection.layoutManager =
            CustomLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mParentVideoCollectionAdapter = ParentVideoCollectionAdapter()
        rv_parent_video_collection.adapter = mParentVideoCollectionAdapter

        mParentVideoCollectionAdapter.setNewData(mParentDataList.toMutableList())

    }

    override fun onBackPressed() {
    }
}