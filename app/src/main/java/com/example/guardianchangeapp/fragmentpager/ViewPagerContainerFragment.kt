package com.example.guardianchangeapp.fragmentpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.guardianchangeapp.databinding.FragmentViewPagerContainerBinding
import com.example.guardianchangeapp.fragmentpager.adapter.FragmentPagerAdapter
import com.example.guardianchangeapp.nestedfragments.favorites.FavoriteFragment
import com.example.guardianchangeapp.nestedfragments.firstTab.SectionFragment
import com.example.guardianchangeapp.nestedfragments.news.NewsFragment


class ViewPagerContainerFragment : Fragment() {
    private lateinit var pagerContainerBinding: FragmentViewPagerContainerBinding
    private lateinit var pagerAdapter: FragmentPagerAdapter
    private var listOfFragments =
        mutableListOf(SectionFragment(), NewsFragment(), FavoriteFragment())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        pagerContainerBinding =
            FragmentViewPagerContainerBinding.inflate(layoutInflater, container, false)
        pagerAdapter = FragmentPagerAdapter(requireActivity(), listOfFragments)
        return pagerContainerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pagerContainerBinding.fragmentPager.adapter = pagerAdapter
    }
}