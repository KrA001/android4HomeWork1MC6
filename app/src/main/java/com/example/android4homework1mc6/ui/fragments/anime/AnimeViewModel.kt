package com.example.android4homework1mc6.ui.fragments.anime

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.data.repositories.AnimeRepository
import com.example.android4homework1mc6.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: AnimeRepository,
) : ViewModel() {

    private val _animeData = MutableLiveData<UiState<List<DataItem>>>(UiState.Loading)
    val animeData: LiveData<UiState<List<DataItem>>>
        get() = _animeData

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        viewModelScope.launch(Dispatchers.IO) {
            repositories.getAnime(
                onSuccess = { _animeData.value = UiState.Success(it) },
                onFailure = { _animeData.value = UiState.Error(RuntimeException(it)) }
            )
        }
    }
}