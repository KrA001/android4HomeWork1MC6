package com.example.android4homework1mc6.ui.fragments.manga

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1mc6.R
import com.example.android4homework1mc6.databinding.FragmentMangaBinding
import com.example.android4homework1mc6.databinding.FragmentViewPagerBinding
import com.example.android4homework1mc6.ui.adapters.MangaAdapter
import com.example.android4homework1mc6.ui.fragments.ViewPagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.fragment_manga) {

    private val binding by viewBinding(FragmentMangaBinding::bind)
    private val mangaAdapter = MangaAdapter(::onItemClick)
    private val viewModels by viewModels<MangaViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
//        subscribe()
        mangaLaunch()

    }

    private fun mangaLaunch() = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) {
                mangaAdapter.loadStateFlow.collect {
                    progressBar.isVisible = it.source.refresh is LoadState.Loading
                    appendProgress.isVisible = it.source.append is LoadState.Loading
                }
            }
        }
    }

    private fun initialize() {
        binding.rvManga.adapter = mangaAdapter

    }

//    private fun subscribe() {
//        viewModels.getManga().observe(viewLifecycleOwner) {
//            viewLifecycleOwner.lifecycleScope.launch {
//                mangaAdapter.submitData(it)
//            }
//        }
//    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            ViewPagerFragmentDirections.actionViewPagerFragmentToDetailFragment2(
                id
            )
        )
    }
}