package com.example.android4homework1mc6.data.base

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class BaseRepository {

    fun <Key : Any, Value : Any> fetchData(pagingSourceFactory: () -> PagingSource<Key, Value>): LiveData<PagingData<Value>> {
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                initialLoadSize = PAGE_SIZE,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { pagingSourceFactory() }
        ).liveData
    }

    fun <T> getAnimeById(data: suspend () -> T) = flow {
        emit(data())
    }.flowOn(Dispatchers.IO)

    companion object {
        private const val PAGE_SIZE = 20
    }
}