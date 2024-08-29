package com.example.android4homework1mc6.ui.fragments.manga

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: KitsuRepository
) : ViewModel() {

    fun getManga() = repositories.fetchManga()
}