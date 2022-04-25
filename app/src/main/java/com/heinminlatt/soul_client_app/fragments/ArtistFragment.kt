package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.activities.ArtistCategoryActivity
import com.heinminlatt.soul_client_app.activities.GroupArtistDetailsActivity
import com.heinminlatt.soul_client_app.adapters.*
import com.heinminlatt.soul_client_app.mvp.presenters.ArtistPresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.ArtistPresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.ArtistView
import com.heinminlatt.soul_client_app.utils.boyGroupArtist
import com.heinminlatt.soul_client_app.utils.girlGroupArtist
import com.heinminlatt.soul_client_app.utils.soloGroupArtist
import kotlinx.android.synthetic.main.artist_boy_group_layout.*
import kotlinx.android.synthetic.main.artist_girl_group_layout.*
import kotlinx.android.synthetic.main.artist_solo_group_layout.*
import kotlinx.android.synthetic.main.fragment_artist.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ArtistFragment : Fragment(),ArtistView {

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArtistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    private lateinit var mBoyArtistAdapter: ArtistBoyAdapter
    private lateinit var mGirlArtistAdapter: ArtistGirlAdapter
    private lateinit var mSoloArtistGroupAdapter: ArtistSoloGroupAdapter

    //presenter
    private lateinit var mArtistPresenter : ArtistPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpViewPagerWithIndicator()
        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpPresenter() {
        mArtistPresenter = ViewModelProviders.of(this).get(ArtistPresenterImpl::class.java)
        mArtistPresenter.initPresenter(this)
    }

    private fun setUpActionListener() {
        iv_viewMore_boy.setOnClickListener {
            startActivity(context?.let { it1 -> ArtistCategoryActivity.newIntent(it1, boyGroupArtist) })
        }

        iv_viewMore_girl.setOnClickListener {
            startActivity(context?.let { it1 -> ArtistCategoryActivity.newIntent(it1, girlGroupArtist) })
        }

        iv_viewMore_solo_artist.setOnClickListener {
            startActivity(context?.let { it1 -> ArtistCategoryActivity.newIntent(it1, soloGroupArtist) })
        }
    }

    private fun setUpViewPagerWithIndicator() {

        val adapter = context?.let { ArtistViewPagerAdapter(it,mArtistPresenter) }
        vp_artist.adapter = adapter
        dots_indicator.setViewPager(vp_artist)
    }

    private fun setUpRecyclerView() {
        //boy group
        rv_boy_group.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mBoyArtistAdapter = ArtistBoyAdapter()
        rv_boy_group.adapter = mBoyArtistAdapter

        mBoyArtistAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))

        //girl group
        rv_girl_group.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mGirlArtistAdapter = ArtistGirlAdapter()
        rv_girl_group.adapter = mGirlArtistAdapter

        mGirlArtistAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))

        //solo group
        rv_solo_group.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mSoloArtistGroupAdapter = ArtistSoloGroupAdapter()
        rv_solo_group.adapter = mSoloArtistGroupAdapter

        mSoloArtistGroupAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }

    override fun navigateToGroupArtistDetailScreen() {
        startActivity(context?.let { it1 -> GroupArtistDetailsActivity.newIntent(it1) })
    }

    override fun showErrorMessage(errorMessage: String) {

    }

}