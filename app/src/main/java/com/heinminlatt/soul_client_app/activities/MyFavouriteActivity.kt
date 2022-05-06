package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.AnimatedImageDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.fragments.MyFavouriteGroupArtistFragment
import com.heinminlatt.soul_client_app.fragments.MyFavouriteNewsFragment
import com.heinminlatt.soul_client_app.fragments.MyFavouriteSoloArtistFragment
import com.heinminlatt.soul_client_app.fragments.MyFavouriteVideoFragment
import kotlinx.android.synthetic.main.activity_create_new_password.*
import kotlinx.android.synthetic.main.activity_my_favourite.*

class MyFavouriteActivity : BaseActivity() {


    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MyFavouriteActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_favourite)
        changeFragment(MyFavouriteNewsFragment.newInstance("", ""))
        setUpActionListener()
    }

    private fun setUpActionListener() {

        iv_back_favourite.setOnClickListener {
            finish()
            slideBackAnimation()
        }

        layout_news.setOnClickListener {

            changeFragment(MyFavouriteNewsFragment.newInstance("", ""))
            //background color
            layout_news.setBackgroundResource(R.drawable.bg_rounded_corner_blue)
            layout_video.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_group_artist.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_solo_artist.setBackgroundResource(R.drawable.bg_rounded_corner_gray)

            //image color
            iv_news.setImageResource(R.drawable.ic_news_white)
            iv_video.setImageResource(R.drawable.ic_video_green)
            iv_group_artist.setImageResource(R.drawable.ic_group_artist_green)
            iv_solo_artist.setImageResource(R.drawable.ic_solo_green)

            //text color
            tv_news.setTextColor(resources.getColor(R.color.white))
            tv_video.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_group_artist.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_solo_artist.setTextColor(resources.getColor(R.color.color_gray_light))

            //text count color
            tv_news_count.setTextColor(resources.getColor(R.color.white))
            tv_video_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_group_artist_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_solo_artist_count.setTextColor(resources.getColor(R.color.color_gray_light))


        }
        layout_video.setOnClickListener {
            changeFragment(MyFavouriteVideoFragment.newInstance("", ""))
            //background color
            layout_news.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_video.setBackgroundResource(R.drawable.bg_rounded_corner_blue)
            layout_group_artist.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_solo_artist.setBackgroundResource(R.drawable.bg_rounded_corner_gray)

            //image color
            iv_news.setImageResource(R.drawable.ic_news_green)
            iv_video.setImageResource(R.drawable.ic_video_white)
            iv_group_artist.setImageResource(R.drawable.ic_group_artist_green)
            iv_solo_artist.setImageResource(R.drawable.ic_solo_green)

            //text color
            tv_news.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_video.setTextColor(resources.getColor(R.color.white))
            tv_group_artist.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_solo_artist.setTextColor(resources.getColor(R.color.color_gray_light))

            //text count color
            tv_news_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_video_count.setTextColor(resources.getColor(R.color.white))
            tv_group_artist_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_solo_artist_count.setTextColor(resources.getColor(R.color.color_gray_light))


        }
        layout_group_artist.setOnClickListener {
            changeFragment(MyFavouriteGroupArtistFragment.newInstance("", ""))

            //background color
            layout_news.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_video.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_group_artist.setBackgroundResource(R.drawable.bg_rounded_corner_blue)
            layout_solo_artist.setBackgroundResource(R.drawable.bg_rounded_corner_gray)


            //image color
            iv_news.setImageResource(R.drawable.ic_news_green)
            iv_video.setImageResource(R.drawable.ic_video_green)
            iv_group_artist.setImageResource(R.drawable.ic_group_artist_white)
            iv_solo_artist.setImageResource(R.drawable.ic_solo_green)

            //text color
            tv_news.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_video.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_group_artist.setTextColor(resources.getColor(R.color.white))
            tv_solo_artist.setTextColor(resources.getColor(R.color.color_gray_light))

            //text count color
            tv_news_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_video_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_group_artist_count.setTextColor(resources.getColor(R.color.white))
            tv_solo_artist_count.setTextColor(resources.getColor(R.color.color_gray_light))
        }
        layout_solo_artist.setOnClickListener {
            changeFragment(MyFavouriteSoloArtistFragment.newInstance("", ""))
            //background color
            layout_news.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_video.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_group_artist.setBackgroundResource(R.drawable.bg_rounded_corner_gray)
            layout_solo_artist.setBackgroundResource(R.drawable.bg_rounded_corner_blue)

            //image color
            iv_news.setImageResource(R.drawable.ic_news_green)
            iv_video.setImageResource(R.drawable.ic_video_green)
            iv_group_artist.setImageResource(R.drawable.ic_group_artist_green)
            iv_solo_artist.setImageResource(R.drawable.ic_solo_white)

            //text color
            tv_news.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_video.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_group_artist.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_solo_artist.setTextColor(resources.getColor(R.color.white))

            //text count color
            tv_news_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_video_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_group_artist_count.setTextColor(resources.getColor(R.color.color_gray_light))
            tv_solo_artist_count.setTextColor(resources.getColor(R.color.white))
        }
    }



    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        slideBackAnimation()
    }
}