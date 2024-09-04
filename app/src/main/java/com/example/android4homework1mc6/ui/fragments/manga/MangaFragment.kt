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
import com.example.android4homework1mc6.databinding.FragmentMangaBinding
import com.example.android4homework1mc6.ui.adapters.MangaAdapter
import com.example.android4homework1mc6.ui.fragments.ViewPagerFragmentDirections
import com.example.android4homework1mc6.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.fragment_manga) {

    private val binding by viewBinding(FragmentMangaBinding::bind)
    private val viewModels by viewModels<MangaViewModel>()
    private val mangaAdapter = MangaAdapter(::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        subscribe()
    }

    private fun initialize() = with(binding) {
        rvManga.adapter = mangaAdapter
    }

    private fun subscribe() {
        viewModels.mangaData.observe(viewLifecycleOwner) { data ->
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
                    mangaAdapter.submitList(data.data)
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