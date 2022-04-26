package com.heinminlatt.soul_client_app.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.heinminlatt.shared.activity.BaseActivity
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.fragments.BoyGroupFragment
import com.heinminlatt.soul_client_app.fragments.GirlGroupFragment
import com.heinminlatt.soul_client_app.fragments.SoloArtistGroupFragment
import com.heinminlatt.soul_client_app.utils.boyGroupArtist
import com.heinminlatt.soul_client_app.utils.girlGroupArtist
import kotlinx.android.synthetic.main.activity_artist_category.*

class ArtistCategoryActivity : BaseActivity() {


    companion object {
       private const val ARTIST_NAME_EXTRA="Artist Name Extra"
        fun newIntent(context: Context,artistName : String) : Intent {
            val intent = Intent(context, ArtistCategoryActivity::class.java)
            intent.putExtra(ARTIST_NAME_EXTRA,artistName)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist_category)

        setUpActionListener()

        checkArtistGroup()
    }

    private fun checkArtistGroup() {
        when {
            intent.getStringExtra(ARTIST_NAME_EXTRA) == boyGroupArtist -> {
                chip_boy_group.isChecked = true
                chip_girl_group.isChecked = false
                chip_solo_artist.isChecked = false

                tv_artist_title.setText(R.string.str_txt_boy_group)
                changeFragment(BoyGroupFragment.newInstance("", ""))
            }
            intent.getStringExtra(ARTIST_NAME_EXTRA) == girlGroupArtist -> {
                chip_boy_group.isChecked = false
                chip_girl_group.isChecked = true
                chip_solo_artist.isChecked = false

                tv_artist_title.setText(R.string.str_txt_girl_group)
                changeFragment(GirlGroupFragment.newInstance("", ""))
            }
            else -> {
                chip_boy_group.isChecked = false
                chip_girl_group.isChecked = false
                chip_solo_artist.isChecked = true

                tv_artist_title.setText(R.string.str_txt_solo)
                changeFragment(SoloArtistGroupFragment.newInstance("", ""))
            }
        }
    }

    private fun setUpActionListener() {
        chip_group.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.chip_boy_group -> {
                    chip_boy_group.setTextColor(resources.getColor(R.color.white))
                    chip_girl_group.setTextColor(resources.getColor(R.color.black))
                    chip_solo_artist.setTextColor(resources.getColor(R.color.black))

                    tv_artist_title.setText(R.string.str_txt_boy_group)

                    changeFragment(BoyGroupFragment.newInstance("",""))
                }
                R.id.chip_girl_group -> {
                    chip_boy_group.setTextColor(resources.getColor(R.color.black))
                    chip_girl_group.setTextColor(resources.getColor(R.color.white))
                    chip_solo_artist.setTextColor(resources.getColor(R.color.black))

                    tv_artist_title.setText(R.string.str_txt_girl_group)
                    changeFragment(GirlGroupFragment.newInstance("",""))
                }
                R.id.chip_solo_artist -> {
                    chip_boy_group.setTextColor(resources.getColor(R.color.black))
                    chip_girl_group.setTextColor(resources.getColor(R.color.black))
                    chip_solo_artist.setTextColor(resources.getColor(R.color.white))

                    tv_artist_title.setText(R.string.str_txt_solo)
                    changeFragment(SoloArtistGroupFragment.newInstance("",""))
                }
            }
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