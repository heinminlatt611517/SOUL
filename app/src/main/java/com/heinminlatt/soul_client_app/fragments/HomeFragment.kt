package com.heinminlatt.soul_client_app.fragments

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.facebook.shimmer.ShimmerFrameLayout
import com.heinminlatt.shared.fragment.BaseFragment
import com.heinminlatt.soul_client_app.R
import com.heinminlatt.soul_client_app.activities.*
import com.heinminlatt.soul_client_app.adapters.*
import com.heinminlatt.soul_client_app.bottomSheetDialogFragments.ReactionBottomSheetFragment
import com.heinminlatt.soul_client_app.mvp.presenters.HomePresenter
import com.heinminlatt.soul_client_app.mvp.presenters.impls.HomePresenterImpl
import com.heinminlatt.soul_client_app.mvp.views.HomeView
import com.heinminlatt.soul_client_app.views.viewPods.SubscriberViewPod
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.home_news_layout.*
import kotlinx.android.synthetic.main.home_search_layout.*
import kotlinx.android.synthetic.main.home_solo_artist_layout.*
import kotlinx.android.synthetic.main.home_videos_layout.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : BaseFragment(), HomeView {

    private var param1: String? = null
    private var param2: String? = null

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
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


    //view pod
    private lateinit var mSubscriberViewPod: SubscriberViewPod


    private lateinit var mSoloArtistAdapter: SoloArtistAdapter
    private lateinit var mNewsTitleAdapter: NewsTitleAdapter
    private lateinit var mNewsAdapter: NewsAdapter
    private lateinit var mHomeVideoAdapter: HomeVideoAdapter

    //presenter
    private lateinit var mHomePresenter: HomePresenter

    //facebook shimmer loading
    private lateinit var mHomeBannerShimmerFrameLayout: ShimmerFrameLayout
    private lateinit var mHomeSoloArtistShimmerFrameLayout: ShimmerFrameLayout
    private lateinit var mHomeNewsShimmerFrameLayout: ShimmerFrameLayout
    private lateinit var mHomeVideoShimmerFrameLayout: ShimmerFrameLayout


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setUpPresenter()

        initView(view)
        firstTimerShowLoading()

        startImageAnimation()
        setUpViewPagerWithIndicator()
        setUpViewPod()
        setUpRecyclerAdapter()
        setUpActionListener()


    }

    private fun initView(view: View) {
        mHomeBannerShimmerFrameLayout = view.findViewById(R.id.home_banner_loading)
        mHomeSoloArtistShimmerFrameLayout = view.findViewById(R.id.home_solo_artist_loading)
        mHomeNewsShimmerFrameLayout = view.findViewById(R.id.home_news_loading)
        mHomeVideoShimmerFrameLayout = view.findViewById(R.id.home_video_loading)
    }

    private fun firstTimerShowLoading() {
        showLoading()
        Handler().postDelayed({
           hideLoading()
        },4000)
    }

    private fun setUpActionListener() {
        iv_search.setOnClickListener {
            mHomePresenter.onTapSearch()
        }

        cup_animationView.setOnClickListener {
            mHomePresenter.onTapQuiz()
        }

        iv_favourite.setOnClickListener {
            mHomePresenter.onTapFavourite()
        }
    }

    private fun startImageAnimation() {
        val animation: Animation = AnimationUtils.loadAnimation(
            context,
            R.anim.bottom_to_original
        )
        //iv_quiz.animation = animation
    }


    private fun setUpPresenter() {
        mHomePresenter = ViewModelProviders.of(this)[HomePresenterImpl::class.java]
        mHomePresenter.initPresenter(this)
    }

    private fun setUpViewPagerWithIndicator() {

        val adapter = context?.let { HomeViewPagerAdapter(it) }
        vp_home_slider.adapter = adapter
        dots_indicator.setViewPager(vp_home_slider)
    }


    private fun setUpRecyclerAdapter() {
        //solo artist
        rv_solo_artist.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mSoloArtistAdapter = SoloArtistAdapter(mHomePresenter)
        rv_solo_artist.adapter = mSoloArtistAdapter

        mSoloArtistAdapter.setNewData(mutableListOf(1, 2, 3, 5, 6, 7, 7, 8, 8, 8))

        //news title
        rv_news_title.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mNewsTitleAdapter = NewsTitleAdapter(mHomePresenter)
        rv_news_title.adapter = mNewsTitleAdapter

        mNewsTitleAdapter.setNewData(mutableListOf("All", "Breaking", "Trending", "Popular"))

        //news
        rv_news.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mNewsAdapter = NewsAdapter(mHomePresenter)
        rv_news.adapter = mNewsAdapter

        mNewsAdapter.setNewData(mutableListOf(1, 2, 3, 4))

        //video recycler view
        rv_videos.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        mHomeVideoAdapter = HomeVideoAdapter()
        rv_videos.adapter = mHomeVideoAdapter
        mHomeVideoAdapter.setNewData(mutableListOf(1, 2, 3, 4))

    }

    private fun setUpViewPod() {
        mSubscriberViewPod = vpSubscriber as SubscriberViewPod
        mSubscriberViewPod.setData("24K", "30K")

    }

    override fun navigateToNewsDetailScreen() {
        startActivity(context?.let { it1 -> NewDetailsActivity.newIntent(it1) })
        slideToAnimation()
    }

    override fun navigateToSoloArtistDetailScreen() {
        startActivity(context?.let { it1 -> SoloArtistDetailsActivity.newIntent(it1) })
        slideToAnimation()
    }

    override fun navigateToSearchScreen() {
        startActivity(context?.let { it1 -> SearchActivity.newIntent(it1) })
        slideTopToBottomAnimation()
    }

    override fun showBottomSheetFragment() {
        val bottomSheetDialogFragment = ReactionBottomSheetFragment()
        activity?.supportFragmentManager?.let { it ->
            bottomSheetDialogFragment.show(
                it,
                bottomSheetDialogFragment.tag
            )
        }
    }

    override fun navigateToMainQuizScreen() {
        startActivity(context?.let { it1 -> MainQuizActivity.newIntent(it1) })
        slideBottomToTopAnimation()
    }

    override fun navigateToMyFavouriteScreen() {
        startActivity(context?.let { it1 -> MyFavouriteActivity.newIntent(it1) })
        slideToAnimation()
    }

    private fun showLoading() {
        layout_home_loading.visibility = View.VISIBLE
        layout_home.visibility = View.GONE
        mHomeBannerShimmerFrameLayout.startShimmer()
        mHomeSoloArtistShimmerFrameLayout.startShimmer()
        mHomeNewsShimmerFrameLayout.startShimmer()
        mHomeVideoShimmerFrameLayout.startShimmer()

    }

    private fun hideLoading() {
        layout_home_loading.visibility = View.GONE
        layout_home.visibility = View.VISIBLE
        mHomeBannerShimmerFrameLayout.stopShimmer()
        mHomeSoloArtistShimmerFrameLayout.stopShimmer()
        mHomeNewsShimmerFrameLayout.stopShimmer()
        mHomeVideoShimmerFrameLayout.stopShimmer()
    }



    override fun showErrorMessage(errorMessage: String) {

    }



}