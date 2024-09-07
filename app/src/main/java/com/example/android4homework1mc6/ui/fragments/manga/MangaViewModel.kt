package com.example.android4homework1mc6.ui.fragments.manga

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.data.repositories.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: MangaRepository,
) : ViewModel() {

    private val _mangaData = MutableLiveData<List<DataItem>>()
    val mangaData: LiveData<List<DataItem>>
        get() = _mangaData

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        viewModelScope.launch(Dispatchers.Main) {
            val data = repositories.getManga().data
            _mangaData.value = data
        }
    }
}