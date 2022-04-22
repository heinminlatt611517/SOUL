package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.*
import kotlinx.android.synthetic.main.fragment_video.*
import kotlinx.android.synthetic.main.home_news_layout.*
import kotlinx.android.synthetic.main.home_solo_artist_layout.*
import kotlinx.android.synthetic.main.top_video_layout.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class VideoFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            VideoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private lateinit var mSoloVideoAdapter: SoloVideoAdapter
    private lateinit var mVideoTitleAdapter: VideoTitleAdapter
    private lateinit var mTopVideoAdapter: TopVideoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        //solo video
        rv_solo_video.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mSoloVideoAdapter = SoloVideoAdapter()
        rv_solo_video.adapter = mSoloVideoAdapter

        mSoloVideoAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))


        // video title
        rv_top_video_title.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mVideoTitleAdapter = VideoTitleAdapter()
        rv_top_video_title.adapter = mVideoTitleAdapter

        mVideoTitleAdapter.setNewData(mutableListOf("Trending","Popular","Edior Choices"))

        //top video
        //solo video
        rv_top_video.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mTopVideoAdapter = TopVideoAdapter()
        rv_top_video.adapter = mTopVideoAdapter

        mTopVideoAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }

    private fun setUpPresenter() {

    }

}