package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.adapters.AllBoyGroupAdapter
import com.heinminlatt.soul_client_app.adapters.TopBoyGroupAdapter
import kotlinx.android.synthetic.main.fragment_girl_group.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class BoyGroupFragment : BaseFragment() {

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BoyGroupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var mTopBoyGroupAdapter: TopBoyGroupAdapter
    private lateinit var mAllBoyGroupAdapter: AllBoyGroupAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_boy_group, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        //top girl group
        rv_top_girl_group.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mTopBoyGroupAdapter = TopBoyGroupAdapter()
        rv_top_girl_group.adapter = mTopBoyGroupAdapter

        mTopBoyGroupAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))

        //all girl group
        rv_all_girl_group.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mAllBoyGroupAdapter = AllBoyGroupAdapter()
        rv_all_girl_group.adapter = mAllBoyGroupAdapter

        mAllBoyGroupAdapter.setNewData(mutableListOf(1,2,3,5,6,7,7,8))
    }


}