package com.example.android4homework1mc6.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.android4homework1mc6.data.repositories.KitsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: KitsuRepository
) : ViewModel() {

    fun fetchAnime() = repositories.fetchAnime()

}