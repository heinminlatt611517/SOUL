package com.heinminlatt.soul_client_app.views.viewPods

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.view_pod_empty.view.*

class EmptyViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    var mDelegate : Delegate? =null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setDelegate(delegate: Delegate){
        mDelegate=delegate
    }

    fun setEmptyData(emptyMessage : String, emptyImageUrl: String){
        tvEmpty.text = emptyMessage

//        Glide.with(context)
//            .load(emptyImageUrl)
//            .into(ivEmptyImage)
    }

    fun setUpListener(){
        btnTryAgain.setOnClickListener {
            mDelegate?.onTapTryAgain()
        }

    }

    interface Delegate{
        fun onTapTryAgain()
    }


}