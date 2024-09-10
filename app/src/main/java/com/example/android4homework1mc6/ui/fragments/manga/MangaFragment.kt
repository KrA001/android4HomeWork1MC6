package com.example.android4homework1mc6.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework1mc6.R
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.databinding.FragmentMangaBinding
import com.example.android4homework1mc6.ui.adapters.MangaAdapter
import com.example.android4homework1mc6.ui.base.BaseFragment
import com.example.android4homework1mc6.ui.fragments.ViewPagerFragmentDirections
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
        viewModel.fetchManga().observe(viewLifecycleOwner) { data ->
            data?.let {
                data as List<DataItem>
                mangaAdapter.submitList(data)
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            ViewPagerFragmentDirections.actionViewPagerFragmentToDetailFragment2(
                id, MANGA_NAME
            )
        )
    }

    companion object {
        const val MANGA_NAME = "manga_name"
    }
}