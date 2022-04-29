package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.MyFavouriteVideoAdapter
import com.heinminlatt.soul_client_app.mvp.presenters.MyFavouritePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.MyFavouritePresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.MyFavouriteView
import kotlinx.android.synthetic.main.fragment_my_favourite_video.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyFavouriteVideoFragment : BaseFragment() ,MyFavouriteView{
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
            MyFavouriteVideoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private lateinit var mMyFavouriteVideoAdapter: MyFavouriteVideoAdapter

    //presenter
    private lateinit var mMyFavouritePresenter: MyFavouritePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_favourite_video, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpRecyclerView()
    }



    private fun setUpPresenter() {
        mMyFavouritePresenter = ViewModelProviders.of(this).get(MyFavouritePresenterImpl::class.java)
        mMyFavouritePresenter.initPresenter(this)
    }

    private fun setUpRecyclerView() {
        //top girl group
        rv_myFavouriteVideo.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mMyFavouriteVideoAdapter = MyFavouriteVideoAdapter(mMyFavouritePresenter)
        rv_myFavouriteVideo.adapter = mMyFavouriteVideoAdapter

        mMyFavouriteVideoAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }

    override fun showErrorMessage(errorMessage: String) {

    }
}