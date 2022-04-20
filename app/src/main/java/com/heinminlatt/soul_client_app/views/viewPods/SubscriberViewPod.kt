package com.heinminlatt.soul_client_app.views.viewPods

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_pod_subscriber.view.*

class SubscriberViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {


    fun setData(data : String , data2 : String){
        tv_sub1.text = data
        tv_sub2.text = data2
    }
}