package com.example.android4homework1mc6.ui.fragments.manga

import androidx.lifecycle.ViewModel
import com.example.android4homework1mc6.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: MangaRepository
) : ViewModel() {

    fun getManga() = repositories.getManga()
}