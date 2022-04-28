package com.heinminlatt.soul_client_app.bottomSheetDialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.heinminlatt.soul_client_app.R


class ReactionBottomSheetFragment : BottomSheetDialogFragment() {

    override fun getTheme() = R.style.NoBackgroundDialogTheme

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = View.inflate(requireContext(), R.layout.fragment_reaction_bottom_sheet, null)
        view.setBackgroundResource(R.drawable.rounded_dialog)
        return view
    }
}