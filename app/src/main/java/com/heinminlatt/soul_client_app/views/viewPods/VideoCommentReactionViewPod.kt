package com.heinminlatt.soul_client_app.views.viewPods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.view_pod_subscriber.view.*
import kotlinx.android.synthetic.main.view_pod_video_comment_reaction.view.*

class VideoCommentReactionViewPod @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    private var firstTimeClickFavourite: Boolean = true
    private var firstTimeClickWoo: Boolean = true
    private var firstTimeClickLaugh: Boolean = true
    private var firstTimeClickSad: Boolean = true

    fun setData(data: String, data2: String) {
        tv_sub1.text = data
        tv_sub2.text = data2
    }


    var mDelegate: Delegate? = null

    fun setDelegate(delegate: Delegate) {
        mDelegate = delegate
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    private fun setUpListener() {
        /**
         * reaction favourite
         */
        iv_reaction_favourite.setOnClickListener {
            firstTimeClickLaugh = true
            firstTimeClickSad = true
            firstTimeClickWoo = true
            mDelegate?.onTapFavourite()

            if (firstTimeClickFavourite) {
                iv_reaction_favourite.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_pink
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_woo.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_laugh.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_sad.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )

                firstTimeClickFavourite = false
            } else {
                iv_reaction_favourite.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                firstTimeClickFavourite = true
            }

        }

        /**
         * reaction woo
         */

        iv_reaction_woo.setOnClickListener {
            firstTimeClickLaugh = true
            firstTimeClickSad = true
            firstTimeClickFavourite = true
            mDelegate?.onTapWoo()
            if (firstTimeClickWoo) {
                iv_reaction_favourite.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_woo.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.purple_700
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_laugh.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_sad.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )

                firstTimeClickWoo = false
            } else {
                iv_reaction_woo.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                firstTimeClickWoo = true
            }

        }


        /**
         * reaction laugh
         */
        iv_reaction_laugh.setOnClickListener {
            firstTimeClickFavourite = true
            firstTimeClickSad = true
            firstTimeClickWoo = true
            mDelegate?.onTapLaugh()

            if (firstTimeClickLaugh) {
                iv_reaction_favourite.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_woo.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_laugh.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gold
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_sad.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                firstTimeClickLaugh = false
            } else {
                iv_reaction_laugh.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                firstTimeClickLaugh = true
            }

        }

        /**
         * reaction sad
         */

        iv_reaction_sad.setOnClickListener {
            firstTimeClickLaugh = true
            firstTimeClickFavourite = true
            firstTimeClickWoo = true
            mDelegate?.onTapSad()

            if (firstTimeClickSad) {
                iv_reaction_favourite.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_woo.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_laugh.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                iv_reaction_sad.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_dark_blue
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                firstTimeClickSad = false
            } else {
                iv_reaction_sad.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                firstTimeClickSad = true
            }

        }

    }

    interface Delegate {
        fun onTapFavourite()
        fun onTapWoo()
        fun onTapSad()
        fun onTapLaugh()
    }

}