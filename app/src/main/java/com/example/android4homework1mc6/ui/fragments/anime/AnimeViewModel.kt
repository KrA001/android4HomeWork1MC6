package com.example.android4homework1mc6.ui.fragments.anime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.data.repositories.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: AnimeRepository,
) : ViewModel() {

    private val _animeData = MutableLiveData<List<DataItem>>()
    val animeData: LiveData<List<DataItem>>
        get() = _animeData

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        viewModelScope.launch(Dispatchers.Main) {
            val data = repositories.getAnime().data
            _animeData.value = data
        }
    }
}