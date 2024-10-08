package com.example.android4homework1mc6.ui.fragments.anime

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1mc6.R
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.databinding.FragmentAnimeBinding
import com.example.android4homework1mc6.ui.adapters.AnimeAdapter
import com.example.android4homework1mc6.ui.base.BaseFragment
import com.example.android4homework1mc6.ui.fragments.ViewPagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : BaseFragment<AnimeViewModel, FragmentAnimeBinding>(R.layout.fragment_anime) {

    override val viewModel: AnimeViewModel by viewModels()
    override val binding by viewBinding(FragmentAnimeBinding::bind)
    private val animeAdapter = AnimeAdapter(::onItemClick)

    override fun initialize() {
        binding.rvAnime.adapter = animeAdapter
    }

    override fun setupObserver() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) { data ->
            data?.let {
                data as List<DataItem>
                animeAdapter.submitList(data)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            ViewPagerFragmentDirections.actionViewPagerFragmentToDetailFragment2(
                id, ANIME_NAME
            )
        )
    }

    companion object {
        const val ANIME_NAME = "anime_name"
    }
}