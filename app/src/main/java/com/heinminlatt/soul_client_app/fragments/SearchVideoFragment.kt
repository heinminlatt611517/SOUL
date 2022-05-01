package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.TopVideoAdapter
import com.heinminlatt.soul_client_app.mvp.presenters.SearchVideoPresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.SearchVideoPresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.SearchVideoVIew
import kotlinx.android.synthetic.main.fragment_search_video.*
import kotlinx.android.synthetic.main.top_video_layout.*
import kotlinx.android.synthetic.main.top_video_layout.rv_top_video

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchVideoFragment : BaseFragment(),SearchVideoVIew {
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
            SearchVideoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private lateinit var mVideoAdapter: TopVideoAdapter
    private lateinit var mPresenter : SearchVideoPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecyclerView()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(SearchVideoPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        rv_search_video.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mVideoAdapter = TopVideoAdapter(mPresenter)
        rv_search_video.adapter = mVideoAdapter

        mVideoAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }

    override fun showErrorMessage(errorMessage: String) {

    }


}