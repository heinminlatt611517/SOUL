package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.NewsAdapter
import com.heinminlatt.soul_client_app.adapters.SearchArtistAdapter
import kotlinx.android.synthetic.main.fragment_search_artist.*
import kotlinx.android.synthetic.main.home_news_layout.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SearchArtistFragment : BaseFragment() {
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
            SearchArtistFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private lateinit var mSearchArtistAdapter: SearchArtistAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_artist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {

        rv_search_artist.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mSearchArtistAdapter = SearchArtistAdapter()
        rv_search_artist.adapter = mSearchArtistAdapter

        mSearchArtistAdapter.setNewData(mutableListOf(1, 2, 3, 4, 5, 6, 7, 8))
    }

}