package com.heinminlatt.soul_client_app.views.viewPods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import com.heinminlatt.soul_client_app.R
import kotlinx.android.synthetic.main.item_solo_video.view.*
import kotlinx.android.synthetic.main.view_pod_reaction.view.*
import kotlinx.android.synthetic.main.view_pod_subscriber.view.*

class ReactionViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    private var firstTimeClickLike: Boolean = true
    private var firstTimeClickUnLike: Boolean = true


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
        iv_reaction_like.setOnClickListener {
            firstTimeClickUnLike = true
            mDelegate?.onTapLike()

            if (firstTimeClickLike) {
                iv_reaction_like.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_pink
                    ), android.graphics.PorterDuff.Mode.SRC_IN
                )

                iv_reaction_unLike.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )

                firstTimeClickLike = false
            } else {
                iv_reaction_like.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_gray_light
                    ), android.graphics.PorterDuff.Mode.SRC_IN
                )

                firstTimeClickLike = true
            }

        }

        iv_reaction_unLike.setOnClickListener {
            firstTimeClickLike = true
            mDelegate?.onTapUnlike()

            if (firstTimeClickUnLike) {
                iv_reaction_unLike.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_pink
                    ), android.graphics.PorterDuff.Mode.SRC_IN
                )

                iv_reaction_like.setColorFilter(
                        ContextCompat.getColor(
                                context,
                                R.color.color_gray_light
                        ), android.graphics.PorterDuff.Mode.SRC_IN
                )

                firstTimeClickUnLike = false
            } else {
                iv_reaction_unLike.setColorFilter(
                    ContextCompat.getColor(
                        context,
                        R.color.color_gray_light
                    ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                firstTimeClickUnLike = true
            }

        }

        iv_reaction_message.setOnClickListener {
            mDelegate?.onTapMessage()
        }

        iv_reaction_more_vest.setOnClickListener {
            mDelegate?.onTapMoreVest()
        }
    }


    interface Delegate {
        fun onTapLike()
        fun onTapUnlike()
        fun onTapMessage()
        fun onTapMoreVest()
    }

}