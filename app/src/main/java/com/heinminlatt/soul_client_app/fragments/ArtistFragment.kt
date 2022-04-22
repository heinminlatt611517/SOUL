package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.*
import kotlinx.android.synthetic.main.artist_boy_group_layout.*
import kotlinx.android.synthetic.main.artist_girl_group_layout.*
import kotlinx.android.synthetic.main.artist_solo_group_layout.*
import kotlinx.android.synthetic.main.fragment_artist.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ArtistFragment : Fragment() {

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPagerWithIndicator()
        setUpRecyclerView()
    }

    private fun setUpViewPagerWithIndicator() {

        val adapter = context?.let { ArtistViewPagerAdapter(it) }
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

}