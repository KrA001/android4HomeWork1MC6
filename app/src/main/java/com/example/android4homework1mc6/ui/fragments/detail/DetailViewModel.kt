package com.example.android4homework1mc6.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.android4homework1mc6.data.base.BaseRepository
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.data.repositories.MangaRepository
import com.example.android4homework1mc6.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val mangaRepository: MangaRepository
) : ViewModel() {

    private var _detailState = MutableLiveData<UiState<DataItem>>(UiState.Loading)
    var detailState: LiveData<UiState<DataItem>> = _detailState
    private val id = savedStateHandle.get<Int>(ID_KEY)

    fun setId(id: Int) {
        savedStateHandle[ID_KEY] = id
    }

    init {
        getMangaById()
        getAnimeById()
    }

    private fun getAnimeById() {
        id?.let {
            _detailState.value = UiState.Success(detailKitsuApi.getAnimeById(it).value)
        }
    }

    private fun getMangaById() {
      detailState = mangaRepository.getMangaById(id).map {
          it.
      }
    }

    companion object {
        private const val ID_KEY = "id"
    }
}