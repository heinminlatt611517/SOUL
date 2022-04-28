package com.heinminlatt.soul_client_app.bottomSheetDialogFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.NewsDetailCommentAdapter
import kotlinx.android.synthetic.main.fragment_news_comment_bottom_sheet.*


class NewsCommentBottomSheetFragment : BottomSheetDialogFragment() {

    override fun getTheme() = R.style.NoBackgroundDialogTheme

    private lateinit var mNewsDetailCommentAdapter: NewsDetailCommentAdapter


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view: View = View.inflate(requireContext(), R.layout.fragment_news_comment_bottom_sheet, null)
        view.setBackgroundResource(R.drawable.rounded_dialog)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        setUpActionListener()
    }

    private fun setUpActionListener() {
        iv_cancel.setOnClickListener {
            dialog?.dismiss()
        }
    }

    private fun setUpRecyclerView() {
        //comment recycler view
        rv_news_detail_comment.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        mNewsDetailCommentAdapter = NewsDetailCommentAdapter()
        rv_news_detail_comment.adapter = mNewsDetailCommentAdapter

        mNewsDetailCommentAdapter.setNewData(mutableListOf(1, 2, 4, 4, 4, 4))
    }
}