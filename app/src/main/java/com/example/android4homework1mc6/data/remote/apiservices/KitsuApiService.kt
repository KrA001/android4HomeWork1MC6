package com.example.android4homework1mc6.data.remote.apiservices

import com.example.android4homework1mc6.data.remote.models.KitsuResponse
import okhttp3.Callback
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
private const val ANIME_END_POINT = "anime/"
private const val MANGA_END_POINT = "manga/"

interface KitsuApiService {

    @GET(ANIME_END_POINT)
    fun getAnime(): Call<KitsuResponse>

    @GET(MANGA_END_POINT)
    fun getManga(): Call<KitsuResponse>
}