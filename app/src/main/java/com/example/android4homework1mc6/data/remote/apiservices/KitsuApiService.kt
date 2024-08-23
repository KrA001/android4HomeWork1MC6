package com.example.android4homework1mc6.data.remote.apiservices

import com.example.android4homework1mc6.data.remote.models.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val ANIME_END_POINT = "anime"
interface KitsuApiService {

    @GET(ANIME_END_POINT)
    suspend fun getAnime(
        @Query("page[limit]") limit: Int,
        @Query("page[offset]") offset: Int
    ): KitsuResponse
}