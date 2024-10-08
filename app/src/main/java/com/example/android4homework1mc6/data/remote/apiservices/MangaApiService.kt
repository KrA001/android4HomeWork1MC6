package com.example.android4homework1mc6.data.remote.apiservices

import com.example.android4homework1mc6.data.remote.models.KitsuResponse
import com.example.android4homework2.data.remote.models.DetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

private const val MANGA_END_POINT = "manga/"
private const val DETAIL_END_POINT_MANGA = "manga/{id}"

interface MangaApiService {

    @GET(MANGA_END_POINT)
    suspend fun getManga(): KitsuResponse

    @GET(DETAIL_END_POINT_MANGA)
    suspend fun getMangaById(
        @Path("id") id: Int
    ): DetailResponse
}