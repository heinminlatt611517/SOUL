package com.heinminlatt.shared.fragment


import androidx.fragment.app.Fragment
import com.heinminlatt.shared.R

abstract class BaseFragment : Fragment() {


    fun slideToAnimation(){
        activity?.overridePendingTransition( R.anim.slide_in, R.anim.slide_out )
    }

    fun slideBackAnimation(){
        activity?.overridePendingTransition( R.anim.slide_enter, R.anim.slide_exit )
    }

    fun slideTopToBottomAnimation(){
        activity?.overridePendingTransition( R.anim.slide_from_top, R.anim.slide_in_top )
    }

    fun slideBottomToTopAnimation(){
        activity?.overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up)
    }




}