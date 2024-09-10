package com.example.android4homework1mc6.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.android4homework1mc6.R
import com.example.android4homework1mc6.databinding.FragmentDetailBinding
import com.example.android4homework1mc6.ui.base.BaseFragment
import com.example.android4homework1mc6.ui.fragments.anime.AnimeFragment
import com.example.android4homework1mc6.ui.fragments.manga.MangaFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment :
    BaseFragment<DetailViewModel, FragmentDetailBinding>(R.layout.fragment_detail) {

    override val viewModel: DetailViewModel by viewModels()
    override val binding by viewBinding(FragmentDetailBinding::bind)

    private val args by navArgs<DetailFragmentArgs>()

    override fun initialize() {

    }

    override fun setupObserver() {
        binding.tvBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun subscribeToDetail() {
        val id = args.id.toInt()
        when (val name = args.name) {
            AnimeFragment.ANIME_NAME -> {
                viewModel.getAnimeById(id).observe(viewLifecycleOwner) { data ->
                    data?.let {
                        it.attributes.posterImage.large.let { posterImage ->
                            Glide.with(binding.artView).load(posterImage).into(binding.artView)
                        }
                    }
                }
            }

            MangaFragment.MANGA_NAME -> {
                viewModel.getMangaById(id).observe(viewLifecycleOwner) { data ->
                    data?.let {
                        it.attributes.posterImage.large.let { posterImage ->
                            Glide.with(binding.artView).load(posterImage).into(binding.artView)
                        }
                    }
                }
            }

            else -> {
                throw RuntimeException("Unknown fragmentName $name")
            }
        }
    }
}