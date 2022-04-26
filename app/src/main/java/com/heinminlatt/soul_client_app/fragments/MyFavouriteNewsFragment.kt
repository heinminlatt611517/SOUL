package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.MyFavouriteNewsAdapter
import com.heinminlatt.soul_client_app.adapters.TopGirlGroupAdapter
import com.heinminlatt.soul_client_app.mvp.presenters.MyFavouritePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.MyFavouritePresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.MyFavouriteView
import kotlinx.android.synthetic.main.fragment_girl_group.*
import kotlinx.android.synthetic.main.fragment_girl_group.rv_top_girl_group
import kotlinx.android.synthetic.main.fragment_my_favourite_news.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MyFavouriteNewsFragment : BaseFragment(),MyFavouriteView {
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
            MyFavouriteNewsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private lateinit var mMyFavouriteNewsAdapter: MyFavouriteNewsAdapter

    //presenter
    private lateinit var mMyFavouritePresenter: MyFavouritePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_favourite_news, container, false)
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
        rv_myFavouriteNews.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mMyFavouriteNewsAdapter = MyFavouriteNewsAdapter(mMyFavouritePresenter)
        rv_myFavouriteNews.adapter = mMyFavouriteNewsAdapter

        mMyFavouriteNewsAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }

    override fun showErrorMessage(errorMessage: String) {

    }

}