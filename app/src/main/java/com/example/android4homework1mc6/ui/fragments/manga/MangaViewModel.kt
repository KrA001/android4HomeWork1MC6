package com.example.android4homework1mc6.ui.fragments.manga

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.data.repositories.MangaRepository
import com.example.android4homework1mc6.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: MangaRepository
) : ViewModel() {

    private val _mangaData = MutableLiveData<UiState<List<DataItem>>>(UiState.Loading)
    val mangaData: LiveData<UiState<List<DataItem>>>
        get() = _mangaData

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        viewModelScope.launch(Dispatchers.IO) {
            repositories.getManga(
                onSuccess = { _mangaData.value = UiState.Success(it) },
                onFailure = { _mangaData.value = UiState.Error(RuntimeException(it)) }
            )
        }
    }
}