package com.example.android4homework1mc6.ui.fragments.manga

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1mc6.R
import com.example.android4homework1mc6.databinding.FragmentAnimeBinding
import com.example.android4homework1mc6.databinding.FragmentMangaBinding
import com.example.android4homework1mc6.ui.adapters.MangaAdapter
import com.example.android4homework1mc6.ui.base.BaseFragment
import com.example.android4homework1mc6.ui.fragments.ViewPagerFragmentDirections
import com.example.android4homework1mc6.ui.fragments.anime.AnimeViewModel
import com.example.android4homework1mc6.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : BaseFragment<MangaViewModel, FragmentMangaBinding>(R.layout.fragment_manga) {


    override val viewModel: MangaViewModel by viewModels()
    override val binding by viewBinding(FragmentMangaBinding::bind)

    private val mangaAdapter = MangaAdapter(::onItemClick)

    override fun initialize() = with(binding) {
        rvManga.adapter = mangaAdapter
    }


    override fun setupObserver() {
        viewModel.mangaData.observe(viewLifecycleOwner) { data ->
            mangaAdapter.submitList(data)
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            ViewPagerFragmentDirections.actionViewPagerFragmentToDetailFragment2(
                id
            )
        )
    }
}