package com.heinminlatt.soul_client_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.heinminlatt.soul_client_app.R



class SoloArtistViewPagerAdapter(private val context: Context) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private val images = arrayOf<Int>(
        R.drawable.artist_boy,
        R.drawable.aritst_girl,
        R.drawable.solo_artist,
        R.drawable.aritst_girl,
        R.drawable.artist_boy
    )

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        val view: View = layoutInflater!!.inflate(R.layout.item_solo_artist_slider, null)
        val imageView = view.findViewById<ImageView>(R.id.iv_home_slider)
        imageView.setImageResource(images[position])
        val viewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager
        val view = `object` as View
        viewPager.removeView(view)
    }
}