package com.example.android4homework1mc6.data.remote.apiservices

import com.example.android4homework1mc6.data.remote.models.KitsuResponse
import com.example.android4homework2.data.remote.models.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

private const val ANIME_END_POINT = "anime/"
private const val DETAIL_END_POINT_ANIME = "anime/{id}"

interface AnimeApiService {

    @GET(ANIME_END_POINT)
    suspend fun getAnime(): KitsuResponse

    @GET(DETAIL_END_POINT_ANIME)
    suspend fun getAnimeById(
        @Path("id") id: Int
    ): DetailResponse
}