package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.MyFavouriteGroupArtistAdapter
import com.heinminlatt.soul_client_app.adapters.MyFavouriteNewsAdapter
import kotlinx.android.synthetic.main.fragment_my_favourite_group_artist.*
import kotlinx.android.synthetic.main.fragment_my_favourite_news.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyFavouriteGroupArtistFragment : BaseFragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyFavouriteGroupArtistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private lateinit var mMyFavouriteGroupArtistAdapter: MyFavouriteGroupArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_favourite_group_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        //top girl group
        rv_my_favourite_group_artist.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mMyFavouriteGroupArtistAdapter = MyFavouriteGroupArtistAdapter()
        rv_my_favourite_group_artist.adapter = mMyFavouriteGroupArtistAdapter

        mMyFavouriteGroupArtistAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }

}