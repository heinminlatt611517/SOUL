package com.heinminlatt.soul_client_app.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.utils.GIVE_UP
import com.heinminlatt.soul_client_app.utils.TIME_UP
import com.heinminlatt.soul_client_app.utils.WRONG_QUIZ
import kotlinx.android.synthetic.main.quiz_dialog.*

class QuizDialogFragment : DialogFragment() {
    companion object {

        const val TAG_RIGHT_DIALOG = "TAG_RIGHT_DIALOG"
        const val BUNDLE_NAME = "BUNDLE_NAME"


        fun newFragment(): QuizDialogFragment {
            return QuizDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quiz_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }


    private fun init(){
        when {
            arguments?.getString(BUNDLE_NAME) == WRONG_QUIZ -> {
                cup_animationView.setAnimation(R.raw.sad_star)
                tv_status_result.text = getString(R.string.str_txt_wrong_status)
                tv_status_result.setTextColor(resources.getColor(R.color.color_view_more))
            }
            arguments?.getString(BUNDLE_NAME) == GIVE_UP -> {
                cup_animationView.setAnimation(R.raw.sad_star)
                tv_status_result.text = getString(R.string.str_txt_give_up_status)
                tv_status_result.setTextColor(resources.getColor(R.color.color_view_more))
            }
            arguments?.getString(BUNDLE_NAME) == TIME_UP -> {
                cup_animationView.setAnimation(R.raw.sad_star)
                tv_status_result.text = getString(R.string.str_txt_time_up_status)
                tv_status_result.setTextColor(resources.getColor(R.color.color_view_more))
                iv_title.setImageDrawable(resources.getDrawable(R.drawable.ic_quiz_time_up_title))

            }
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.FILL_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog?.window?.setBackgroundDrawableResource(android.R.color.transparent)
    }
}