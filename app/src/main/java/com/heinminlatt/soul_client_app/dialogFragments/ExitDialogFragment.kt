package com.heinminlatt.soul_client_app.dialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.heinminlatt.shared.dialogFragment.BaseDialogFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.activities.FinalScoreActivity
import com.heinminlatt.soul_client_app.activities.SoloArtistDetailsActivity
import kotlinx.android.synthetic.main.quiz_exit_dialog.*

class ExitDialogFragment : BaseDialogFragment() {
    companion object {

        const val TAG_EXIT_DIALOG = "TAG_EXIT_DIALOG"
        const val BUNDLE_NAME = "BUNDLE_NAME"


        fun newFragment(): ExitDialogFragment {
            return ExitDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.quiz_exit_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        btn_exit.setOnClickListener {
            startActivity(context?.let { it1 -> FinalScoreActivity.newIntent(it1) })
            slideToAnimation()
            dismissDialog()
        }

        btn_no.setOnClickListener {
            dismissDialog()
        }
    }

    private fun init(){
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