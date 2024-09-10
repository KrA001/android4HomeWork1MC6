package com.example.android4homework1mc6.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.data.repositories.AnimeRepository
import com.example.android4homework1mc6.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val mangaRepository: MangaRepository,
    private val animeRepository: AnimeRepository,
) : ViewModel() {

    private var _detailState = MutableLiveData<DataItem>()
    val detailState: LiveData<DataItem> = _detailState

    fun getAnimeById(id: Int) = animeRepository.getAnimeById(id)

    fun getMangaById(id: Int) = mangaRepository.getMangaById(id)
}