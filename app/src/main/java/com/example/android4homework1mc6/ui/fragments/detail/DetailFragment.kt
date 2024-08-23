package com.example.android4homework1mc6.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.android4homework1mc6.R
import com.example.android4homework1mc6.databinding.FragmentAnimeBinding
import com.example.android4homework1mc6.databinding.FragmentDetailBinding
import com.example.android4homework1mc6.utils.UiState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.id?.let { id ->
            viewModel.setId(id)
        }
        subscribeToDetail(view)
        setupListeners()
    }

    private fun subscribeToDetail(view: View) {
        viewModel.detailState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UiState.Error -> uiState.message?.let {
                    Snackbar.make(
                        requireView(), it, Snackbar.LENGTH_SHORT
                    ).show()
                }

                UiState.Loading -> binding.progressBar.isVisible = true

                is UiState.Success -> {
                    binding.progressBar.isVisible = false
                    uiState.data?.let {
                        binding.tvDay.text = it.attributes.startDate
                        binding.tvName.text = it.attributes.titles.en
                        it.attributes.coverImage?.large?.let { coverImage ->
                            Glide.with(binding.fonView).load(coverImage).into(binding.fonView)
                        }
                        Glide.with(binding.artView).load(it.attributes.posterImage.large)
                            .into(binding.artView)
                    }
                }
            }
        }
    }

    private fun setupListeners() {
        binding.tvBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}