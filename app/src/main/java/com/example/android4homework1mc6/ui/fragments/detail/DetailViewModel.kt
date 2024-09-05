package com.example.android4homework1mc6.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.data.repositories.AnimeRepository
import com.example.android4homework1mc6.data.repositories.MangaRepository
import com.example.android4homework1mc6.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val mangaRepository: MangaRepository,
    private val animeRepository: AnimeRepository,
) : ViewModel() {

    private val _detailState = MutableLiveData<UiState<DataItem>>(UiState.Loading)
    val detailState: LiveData<UiState<DataItem>> = _detailState
    private val id = savedStateHandle.get<String>(ID_KEY)

    fun setId(id: String) {
        savedStateHandle[ID_KEY] = id
    }

    init {
        getMangaById()
        getAnimeById()
    }

    private fun getAnimeById() {
        viewModelScope.launch(Dispatchers.IO) {
            id?.let {
                animeRepository.getAnimeById(
                    id = id.toInt(),
                    onSuccess = { _detailState.value = UiState.Success() },
                    onFailure = { _detailState.value = UiState.Error(RuntimeException()) }
                )
            }
        }
    }

    private fun getMangaById() {
        viewModelScope.launch(Dispatchers.IO) {
            id?.let {
                mangaRepository.getMangaById(
                    id = id.toInt(),
                    onSuccess = { _detailState.value = UiState.Success() },
                    onFailure = { _detailState.value = UiState.Error(RuntimeException()) }
                )
            }
        }
    }

    companion object {
        private const val ID_KEY = "id"
    }
}