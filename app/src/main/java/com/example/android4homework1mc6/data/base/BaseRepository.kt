package com.example.android4homework1mc6.data.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.liveData
import com.example.android4homework1mc6.utils.UiState

abstract class BaseRepository {

    fun <Key: Any, Value:Any> fetchData(pagingSourceFactory: () -> PagingSource<Key, Value>): LiveData<PagingData<Value>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { pagingSourceFactory()}
        ).liveData
    }

    fun <T> getAnimeById(data: () -> T) = liveData<UiState<T>> {
        emit(UiState.Loading)
        try {
            emit(UiState.Success(data()))
        } catch (e: Exception) {
            emit(UiState.Error(e))
        }
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}