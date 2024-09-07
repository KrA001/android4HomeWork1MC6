package com.example.android4homework1mc6.data.repositories

import com.example.android4homework1mc6.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService,
) {
    suspend fun getAnime() = animeApiService.getAnime()

    suspend fun getAnimeById(id: Int) = animeApiService.getAnimeById(id)
}