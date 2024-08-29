package com.example.android4homework1mc6.data.repositories

import com.example.android4homework1mc6.data.base.BaseRepository
import com.example.android4homework1mc6.data.remote.apiservices.DetailApiService
import com.example.android4homework1mc6.data.remote.apiservices.KitsuApiService
import com.example.android4homework1mc6.data.remote.apiservices.paging.MangaPagingSource
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val kitsuApiService : KitsuApiService,
    private val detailApiService: DetailApiService,
) : BaseRepository() {
    fun getManga() = fetchData { MangaPagingSource(kitsuApiService) }

    fun getMangaById(id: Int) = getAnimeById { detailApiService.getMangaBYId(id) }
}