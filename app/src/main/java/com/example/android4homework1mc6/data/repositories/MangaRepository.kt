package com.example.android4homework1mc6.data.repositories

import com.example.android4homework1mc6.data.remote.apiservices.MangaApiService
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val mangaApiService: MangaApiService,
) {
    suspend fun getManga() = mangaApiService.getManga()

    suspend fun getMangaById(id: Int) = mangaApiService.getMangaById(id)
}