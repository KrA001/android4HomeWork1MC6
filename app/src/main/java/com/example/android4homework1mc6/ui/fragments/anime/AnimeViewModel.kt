package com.example.android4homework1mc6.ui.fragments.anime

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.android4homework1mc6.data.remote.models.KitsuResponse
import com.example.android4homework1mc6.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: AnimeRepository,
) : ViewModel() {

    fun fetchAnime() = repositories.getAnime() as LiveData<List<KitsuResponse>>
}