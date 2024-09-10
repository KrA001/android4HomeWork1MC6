package com.example.android4homework1mc6.data.repositories

import com.example.android4homework1mc6.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService,
) : BaseRepository(){

    fun getManga() = fetchData { mangaApiService.getManga().data }

    fun getMangaById(id: Int) = fetchData { mangaApiService.getMangaById(id).data }
}