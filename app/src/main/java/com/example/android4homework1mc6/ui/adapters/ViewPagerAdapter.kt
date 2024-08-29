package com.example.android4homework1mc6.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android4homework1mc6.ui.fragments.ViewPagerFragment
import com.example.android4homework1mc6.ui.fragments.anime.AnimeFragment
import com.example.android4homework1mc6.ui.fragments.manga.MangaFragment

class ViewPagerAdapter(fragment: ViewPagerFragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return if (position == 1) MangaFragment() else AnimeFragment()
    }
}