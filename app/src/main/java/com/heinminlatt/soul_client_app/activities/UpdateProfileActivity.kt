package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.hbb20.CountryCodePicker
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.mvp.presenters.UpdateProfilePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.LoginPresenterImpl
import com.heinminlatt.soul_client_app.mvp.presenters.impls.UpdateProfilePresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.UpdateProfileView
import kotlinx.android.synthetic.main.activity_update_profile.*

class UpdateProfileActivity : BaseActivity(), CountryCodePicker.OnCountryChangeListener,UpdateProfileView{

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, UpdateProfileActivity::class.java)
        }
    }

    private var countryCode:String?=null
    private var countryName:String?=null

    private lateinit var mPresenter : UpdateProfilePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_profile)

        setUpPresenter()
        setUpActionListener()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(UpdateProfilePresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpActionListener() {
        country_code_picker!!.setOnCountryChangeListener(this)

        btn_let_rock.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
            finish()
        }

        tv_skip.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
            finish()
        }

    }

    override fun onCountrySelected() {
        countryCode=country_code_picker!!.selectedCountryCode
        countryName=country_code_picker!!.selectedCountryName

        //Toast.makeText(this, "Country Code$countryCode",Toast.LENGTH_LONG).show()
    }

    override fun navigateToMainScreen() {

    }

    override fun showErrorMessage(errorMessage: String) {

    }
}