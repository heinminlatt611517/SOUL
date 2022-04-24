package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.AllGirlGroupAdapter
import com.heinminlatt.soul_client_app.adapters.ArtistBoyAdapter
import com.heinminlatt.soul_client_app.adapters.ArtistGirlAdapter
import com.heinminlatt.soul_client_app.adapters.TopGirlGroupAdapter
import kotlinx.android.synthetic.main.artist_boy_group_layout.*
import kotlinx.android.synthetic.main.artist_girl_group_layout.*
import kotlinx.android.synthetic.main.fragment_girl_group.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class GirlGroupFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GirlGroupFragment().apply {
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

    private lateinit var mTopGirlGroupAdapter: TopGirlGroupAdapter
    private lateinit var mAllGirlGroupAdapter: AllGirlGroupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_girl_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        //top girl group
        rv_top_girl_group.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mTopGirlGroupAdapter = TopGirlGroupAdapter()
        rv_top_girl_group.adapter = mTopGirlGroupAdapter

        mTopGirlGroupAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))

        //all girl group
        rv_all_girl_group.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mAllGirlGroupAdapter = AllGirlGroupAdapter()
        rv_all_girl_group.adapter = mAllGirlGroupAdapter

        mAllGirlGroupAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }


}