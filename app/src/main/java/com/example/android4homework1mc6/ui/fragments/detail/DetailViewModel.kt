package com.example.android4homework1mc6.ui.fragments.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4homework1mc6.data.repositories.KitsuRepository
import com.example.android4homework1mc6.utils.UiState
import com.example.android4homework1mc6.data.remote.models.DataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val detailKitsuApi: KitsuRepository,
) : ViewModel() {

    private val _detailState = MutableLiveData<UiState<DataItem>>(UiState.Loading)
    val detailState: LiveData<UiState<DataItem>> = _detailState
    private val id = savedStateHandle.get<String>(ID_KEY)

    fun setId(id: String) {
        savedStateHandle[ID_KEY] = id
    }

    init {
        getAnimeById()
    }

    private fun getAnimeById() {
        viewModelScope.launch {
            id?.let {
                detailKitsuApi.getAnimeById(id.toInt()).catch {
                    _detailState.value = UiState.Error(it, it.message ?: "Unknown error")
                }
                    .collect {
                        _detailState.value = UiState.Success(it)
                    }
            }
        }
    }

    companion object {
        private const val ID_KEY = "id"
    }
}