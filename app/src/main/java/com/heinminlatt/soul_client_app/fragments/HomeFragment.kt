package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.NewsTitleAdapter
import com.heinminlatt.soul_client_app.adapters.SoloArtistAdapter
import com.heinminlatt.soul_client_app.mvp.presenters.HomePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.HomePresenterImpl
import com.heinminlatt.soul_client_app.mvp.presenters.impls.SignUpPresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.HomeView
import com.heinminlatt.soul_client_app.views.viewPods.SubscriberViewPod
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.home_news_layout.*
import kotlinx.android.synthetic.main.home_solo_artist_layout.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() , HomeView{

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
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


    private lateinit var mViewPodSubscriber : SubscriberViewPod
    private lateinit var mSoloArtistAdapter: SoloArtistAdapter
    private lateinit var mNewsTitleAdapter: NewsTitleAdapter

    private lateinit var mHomePresenter : HomePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()

        setUpSubscriberViewPod()
        setUpRecyclerAdapter()

    }

    private fun setUpPresenter() {
        mHomePresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
        mHomePresenter.initPresenter(this)
    }

    private fun setUpRecyclerAdapter() {
        //solo artist
        rv_solo_artist.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mSoloArtistAdapter = SoloArtistAdapter()
        rv_solo_artist.adapter = mSoloArtistAdapter

        mSoloArtistAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8,8,8))

        //news
        rv_news_title.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mNewsTitleAdapter = NewsTitleAdapter(mHomePresenter)
        rv_news_title.adapter = mNewsTitleAdapter

        mNewsTitleAdapter.setNewData(mutableListOf("All","Breaking","Trending","Popular"))

    }

    private fun setUpSubscriberViewPod() {
        mViewPodSubscriber = vpSubscriber as SubscriberViewPod
        mViewPodSubscriber.setData("24K","30K")

    }

    override fun refreshNewsTitle() {
        mNewsTitleAdapter.notifyDataSetChanged()
    }

    override fun showErrorMessage(errorMessage: String) {

    }


}