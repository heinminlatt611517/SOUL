package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.fragments.MyFavouriteGroupArtistFragment
import com.heinminlatt.soul_client_app.fragments.MyFavouriteNewsFragment
import com.heinminlatt.soul_client_app.fragments.MyFavouriteSoloArtistFragment
import com.heinminlatt.soul_client_app.fragments.MyFavouriteVideoFragment
import kotlinx.android.synthetic.main.activity_my_favourite.*

class MyFavouriteActivity : BaseActivity() {


    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, MyFavouriteActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_favourite)
        changeFragment(MyFavouriteNewsFragment.newInstance("",""))
        setUpActionListener()
    }

    private fun setUpActionListener() {

        layout_news.setOnClickListener {
            layout_news.setBackgroundResource(R.drawable.gradient_stroke_color)
            layout_video.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_group_artist.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_solo_artist.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)


            changeFragment(MyFavouriteNewsFragment.newInstance("",""))
        }
        layout_video.setOnClickListener {
            layout_news.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_video.setBackgroundResource(R.drawable.gradient_stroke_color)
            layout_group_artist.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_solo_artist.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)

            changeFragment(MyFavouriteVideoFragment.newInstance("",""))
        }
        layout_group_artist.setOnClickListener {
            layout_news.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_video.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_group_artist.setBackgroundResource(R.drawable.gradient_stroke_color)
            layout_solo_artist.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)

            changeFragment(MyFavouriteGroupArtistFragment.newInstance("",""))
        }
        layout_solo_artist.setOnClickListener {
            layout_news.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_video.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_group_artist.setBackgroundResource(R.drawable.fav_bg_rounded_corner_gray)
            layout_solo_artist.setBackgroundResource(R.drawable.gradient_stroke_color)

            changeFragment(MyFavouriteSoloArtistFragment.newInstance("",""))
        }
    }



    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }

    override fun finish() {
        super.finish()
       slideBackAnimation()
    }
}