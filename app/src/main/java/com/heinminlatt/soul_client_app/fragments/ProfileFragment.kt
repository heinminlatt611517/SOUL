package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.activities.EditProfileActivity
import com.heinminlatt.soul_client_app.activities.MyFavouriteActivity
import com.heinminlatt.soul_client_app.activities.SettingActivity
import com.heinminlatt.soul_client_app.mvp.presenters.ProfilePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.ProfilePresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.ProfileView
import kotlinx.android.synthetic.main.fragment_profile.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class AccountFragment : BaseFragment() ,ProfileView{

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
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

    //presenter
    private lateinit var mProfilePresenter : ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_right_arrow.setOnClickListener {
            mProfilePresenter.onTapEditProfile()
        }

        setting_layout.setOnClickListener {
            mProfilePresenter.onTapSetting()
        }

        iv_favourite_right_arrow.setOnClickListener {
            mProfilePresenter.onTapMyFavourite()
        }

    }

    private fun setUpPresenter() {
        mProfilePresenter = ViewModelProviders.of(this).get(ProfilePresenterImpl::class.java)
        mProfilePresenter.initPresenter(this)
    }

    override fun navigateToSettingScreen() {
        startActivity(context?.let { it1 -> SettingActivity.newIntent(it1) })
        slideToAnimation()
    }

    override fun navigateToEditProfileScreen() {
        startActivity(context?.let { it1 -> EditProfileActivity.newIntent(it1) })
       slideToAnimation()
    }

    override fun navigateToMyFavouriteScreen() {
        startActivity(context?.let { it1 -> MyFavouriteActivity.newIntent(it1) })
        slideToAnimation()
    }

    override fun showErrorMessage(errorMessage: String) {

    }

}