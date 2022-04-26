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

}