package com.example.android4homework1mc6.data.remote.apiservices

import com.example.android4homework2.data.remote.models.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

private const val DETAIL_END_POINT_MANGA = "manga/{id}"

interface DetailApiService {
    @GET(DETAIL_END_POINT_MANGA)
    suspend fun getAnimeById(
        @Path("id") id: Int
    ): DetailResponse
}