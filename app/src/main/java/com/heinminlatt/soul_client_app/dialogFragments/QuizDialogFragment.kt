package com.heinminlatt.soul_client_app.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heinminlatt.shared.dialogFragment.BaseDialogFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.activities.FinalScoreActivity
import com.heinminlatt.soul_client_app.activities.SoloArtistDetailsActivity
import com.heinminlatt.soul_client_app.utils.*
import kotlinx.android.synthetic.main.quiz_dialog.*
import kotlinx.android.synthetic.main.quiz_dialog.btn_exitQuiz
import kotlinx.android.synthetic.main.quiz_dialog.btn_nextQuiz
import kotlinx.android.synthetic.main.quiz_dialog.iv_title

class QuizDialogFragment : BaseDialogFragment() {
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
        setUpActionListener()
    }

    private fun setUpActionListener() {
        btn_exitQuiz.setOnClickListener {
            if(arguments?.getString(BUNDLE_NAME) == RIGHT_QUIZ)
            {
                dismissDialog()
                startActivity(context?.let { it1 -> FinalScoreActivity.newIntent(it1) })
                slideToAnimation()
            }
            else{
                dismissDialog()
                showExitDialogFragment()
            }

        }

        btn_nextQuiz.setOnClickListener {
            dismissDialog()
        }
    }


    private fun init(){
        when {
            arguments?.getString(BUNDLE_NAME) == WRONG_QUIZ -> {
                cup_animationView.setAnimation(R.raw.sad_star)
                tv_status_result.text = getString(R.string.str_txt_wrong_status)
                tv_status_result.setTextColor(resources.getColor(R.color.color_view_more))
                tv_scorePoint.text = "-1"
                tv_scorePoint.setTextColor(resources.getColor(R.color.color_view_more))
            }
            arguments?.getString(BUNDLE_NAME) == GIVE_UP -> {
                cup_animationView.setAnimation(R.raw.sad_star)
                tv_status_result.text = getString(R.string.str_txt_give_up_status)
                tv_status_result.setTextColor(resources.getColor(R.color.color_view_more))
                tv_scorePoint.text = "-1"
                tv_scorePoint.setTextColor(resources.getColor(R.color.color_view_more))
            }
            arguments?.getString(BUNDLE_NAME) == TIME_UP -> {
                cup_animationView.setAnimation(R.raw.sad_star)
                tv_status_result.text = getString(R.string.str_txt_time_up_status)
                tv_status_result.setTextColor(resources.getColor(R.color.color_view_more))
                iv_title.setImageDrawable(resources.getDrawable(R.drawable.ic_quiz_time_up_title))
                tv_scorePoint.text = "-1"
                tv_scorePoint.setTextColor(resources.getColor(R.color.color_view_more))

            }
        }
    }

    private fun showExitDialogFragment(){
        val quizExitDialog = ExitDialogFragment.newFragment()
        val bundle = Bundle()
        bundle.putString(BUNDLE_NAME, EXIT)
        quizExitDialog.arguments = bundle
        activity?.supportFragmentManager.let {
            it?.let { it1 ->
                quizExitDialog.show(
                        it1,
                        ExitDialogFragment.TAG_EXIT_DIALOG
                )
            }
        }
    }

    private fun dismissDialog(){
        dialog?.dismiss()
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