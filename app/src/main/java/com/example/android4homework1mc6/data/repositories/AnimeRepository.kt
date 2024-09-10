package com.example.android4homework1mc6.data.repositories

import com.example.android4homework1mc6.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val animeApiService: AnimeApiService,
) : BaseRepository() {

    fun getAnime() = fetchData { animeApiService.getAnime().data }

    fun getAnimeById(id: Int) = fetchData { animeApiService.getAnimeById(id).data }
}