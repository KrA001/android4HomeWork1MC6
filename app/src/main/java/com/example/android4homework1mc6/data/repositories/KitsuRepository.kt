package com.example.android4homework1mc6.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.android4homework1mc6.data.remote.apiservices.KitsuApiService
import com.example.android4homework1mc6.data.remote.apiservices.DetailApiService
import com.example.android4homework1mc6.data.remote.apiservices.paging.AnimePagingSource
import com.example.android4homework1mc6.data.remote.models.DataItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KitsuRepository @Inject constructor(
    private val kitsuApiService: KitsuApiService,
    private val detailKitsuApi: DetailApiService
) {
    fun fetchAnime(): LiveData<PagingData<DataItem>> {

        return Pager(
            config = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20,
                enablePlaceholders = true
            ),
            pagingSourceFactory = { AnimePagingSource(kitsuApiService) }
        ).liveData
    }

    fun getAnimeById(id: Int) = flow {
        emit(detailKitsuApi.getAnimeById(id).data)
    }.flowOn(Dispatchers.IO)

}