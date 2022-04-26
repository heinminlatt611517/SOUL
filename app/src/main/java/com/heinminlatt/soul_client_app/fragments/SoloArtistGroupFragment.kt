package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.*
import kotlinx.android.synthetic.main.fragment_girl_group.*
import kotlinx.android.synthetic.main.fragment_solo_artist.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SoloArtistGroupFragment : BaseFragment() {
    private var param1: String? = null
    private var param2: String? = null
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SoloArtistGroupFragment().apply {
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

    private lateinit var mTopSoloArtistGroupAdapter: TopSoloArtistGroupAdapter
    private lateinit var mAllSoloArtistGroupAdapter: AllSoloArtistGroupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_solo_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        //top solo artist group
        rv_top_solo_artist_group.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mTopSoloArtistGroupAdapter = TopSoloArtistGroupAdapter()
        rv_top_solo_artist_group.adapter = mTopSoloArtistGroupAdapter

        mTopSoloArtistGroupAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))

        //all solo artist group
        rv_all_solo_artist.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mAllSoloArtistGroupAdapter = AllSoloArtistGroupAdapter()
        rv_all_solo_artist.adapter = mAllSoloArtistGroupAdapter



        mAllSoloArtistGroupAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }

}