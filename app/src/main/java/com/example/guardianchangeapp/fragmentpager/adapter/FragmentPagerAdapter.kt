package com.example.guardianchangeapp.fragmentpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val listOfFragments: List<Fragment>
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = listOfFragments.size
    override fun createFragment(position: Int): Fragment {
        return listOfFragments[position]
    }

}