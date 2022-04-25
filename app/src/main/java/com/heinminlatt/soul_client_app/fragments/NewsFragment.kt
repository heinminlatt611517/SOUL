package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.activities.NewDetailsActivity
import com.heinminlatt.soul_client_app.adapters.NewsAdapter
import com.heinminlatt.soul_client_app.adapters.NewsTitleAdapter
import com.heinminlatt.soul_client_app.adapters.SoloVideoAdapter
import com.heinminlatt.soul_client_app.adapters.TopNewsAdapter
import com.heinminlatt.soul_client_app.mvp.presenters.NewsPresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.HomePresenterImpl
import com.heinminlatt.soul_client_app.mvp.presenters.impls.NewsPresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.NewsView
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.fragment_video.*
import kotlinx.android.synthetic.main.home_news_layout.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NewsFragment : Fragment(),NewsView {

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFragment().apply {
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

    private lateinit var mTopNewsAdapter: TopNewsAdapter
    private lateinit var mNewsTitleAdapter: NewsTitleAdapter
    private lateinit var mNewsAdapter: NewsAdapter

    //presenter
    private lateinit var mNewsPresenter : NewsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()
    }

    private fun setUpPresenter() {
        mNewsPresenter = ViewModelProviders.of(this).get(NewsPresenterImpl::class.java)
        mNewsPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        //top news
        rv_top_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mTopNewsAdapter = TopNewsAdapter()
        rv_top_news.adapter = mTopNewsAdapter

        mTopNewsAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))

        //news title
        rv_news_title.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mNewsTitleAdapter = NewsTitleAdapter(mNewsPresenter)
        rv_news_title.adapter = mNewsTitleAdapter

        mNewsTitleAdapter.setNewData(mutableListOf("All","Breaking","Trending","Popular"))

        //news
        rv_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mNewsAdapter = NewsAdapter(mNewsPresenter)
        rv_news.adapter = mNewsAdapter

        mNewsAdapter.setNewData(mutableListOf(1,2,3,4,5,6,7,8))
    }

    override fun navigateToNewsDetailScreen() {
        startActivity(context?.let { it1 -> NewDetailsActivity.newIntent(it1) })
    }

    override fun showErrorMessage(errorMessage: String) {

    }


}