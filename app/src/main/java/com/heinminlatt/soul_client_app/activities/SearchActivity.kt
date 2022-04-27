package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.fragment.app.Fragment
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.shared.activity.hideKeyboard
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.fragments.SearchArtistFragment
import com.heinminlatt.soul_client_app.fragments.SearchNewsFragment
import com.heinminlatt.soul_client_app.fragments.SearchSoloFragment
import com.heinminlatt.soul_client_app.fragments.SearchVideoFragment
import com.heinminlatt.soul_client_app.utils.ARTISTS
import com.heinminlatt.soul_client_app.utils.NEWS
import com.heinminlatt.soul_client_app.utils.SOLO
import com.heinminlatt.soul_client_app.utils.VIDEOS
import kotlinx.android.synthetic.main.activity_create_new_password.iv_back
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SearchActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_back.setOnClickListener {
            finish()
        }


        iv_clear_search.setOnClickListener {
            edt_search.setText("")
        }

        tv_artist.setOnClickListener {
            edt_search.setText(tv_artist.text)
        }

        tv_news.setOnClickListener {
            edt_search.setText(tv_news.text)
        }

        tv_video.setOnClickListener {
            edt_search.setText(tv_video.text)
        }

        tv_solo.setOnClickListener {
            edt_search.setText(tv_solo.text)
        }

        edt_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                filter(s.toString())
                Log.d("SearchText",edt_search.text.toString())
                when {
                    s.toString()!="" -> {
                        iv_clear_search.visibility = View.VISIBLE


                        when {
                            s.toString() == ARTISTS -> {
                                changeFragment(SearchArtistFragment.newInstance("",""))
                                textLayout.visibility = View.GONE
                                flContainer.visibility = View.VISIBLE
                            }
                            s.toString() == NEWS -> {
                                changeFragment(SearchNewsFragment.newInstance("",""))
                                textLayout.visibility = View.GONE
                                flContainer.visibility = View.VISIBLE
                            }
                            s.toString() == VIDEOS -> {
                                changeFragment(SearchVideoFragment.newInstance("",""))
                                textLayout.visibility = View.GONE
                                flContainer.visibility = View.VISIBLE
                            }
                            s.toString() == SOLO -> {
                                changeFragment(SearchSoloFragment.newInstance("",""))
                                textLayout.visibility = View.GONE
                                flContainer.visibility = View.VISIBLE
                            }
                        }
                    }
                    else -> {
                        iv_clear_search.visibility = View.GONE
                        flContainer.visibility = View.GONE
                        textLayout.visibility = View.VISIBLE
                    }
                }

            }
        })

    }

    fun filter(text : String)
    {

    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        hideKeyboard(this)
        return super.dispatchTouchEvent(ev)
    }


    override fun finish() {
        super.finish()
        slideBottomToTopAnimation()
    }


}