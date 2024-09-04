package com.example.android4homework1mc6.ui.fragments.anime

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
import com.example.android4homework1mc6.ui.adapters.AnimeAdapter
import com.example.android4homework1mc6.ui.fragments.ViewPagerFragmentDirections
import com.example.android4homework1mc6.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
    }

    private fun initialize() = with(binding) {
        rvAnime.adapter = animeAdapter
    }

    private fun setupObserver() {
        viewModel.animeData.observe(viewLifecycleOwner) { data ->
            when (data) {
                is UiState.Error -> {
                    Log.e("error", data.message.toString())
                    binding.progressBar.isVisible = false
                }

                is UiState.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is UiState.Success -> {
                    binding.progressBar.isVisible = false
                    animeAdapter.submitList(data.data)
                }
            }
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