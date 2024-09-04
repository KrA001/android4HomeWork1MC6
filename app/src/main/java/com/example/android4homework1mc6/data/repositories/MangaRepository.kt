package com.example.android4homework1mc6.data.repositories

import com.example.android4homework1mc6.data.base.BaseRepository
import com.example.android4homework1mc6.data.remote.apiservices.DetailApiService
import com.example.android4homework1mc6.data.remote.apiservices.KitsuApiService
import com.example.android4homework1mc6.data.remote.models.DataItem
import com.example.android4homework1mc6.data.remote.models.KitsuResponse
import com.example.android4homework2.data.remote.models.DetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val kitsuApiService : KitsuApiService,
    private val detailApiService: DetailApiService,
) : BaseRepository() {

    fun getManga(onSuccess: (data: List<DataItem>) -> Unit, onFailure: (error: String) -> Unit) {
        kitsuApiService.getAnime().enqueue(object : Callback<KitsuResponse> {
            override fun onResponse(p0: Call<KitsuResponse>, p1: Response<KitsuResponse>) {
                if (p1.isSuccessful && p1.body() != null) {
                    p1.body()?.let {
                        onSuccess(it.data)
                    }
                }
            }

            override fun onFailure(p0: Call<KitsuResponse>, p1: Throwable) {
                onFailure(p1.message.toString())
            }
        })
    }

    fun getMangaById(id: Int,onSuccess: (data: DataItem) -> Unit, onFailure: (error: String) -> Unit) {
        detailApiService.getAnimeById(id).enqueue(object : Callback<DetailResponse> {
            override fun onResponse(p0: Call<DetailResponse>, p1: Response<DetailResponse>) {
                if (p1.isSuccessful && p1.body() != null) {
                    p1.body()?.let {
                        onSuccess(it.data)
                    }
                }
            }

            override fun onFailure(p0: Call<DetailResponse>, p1: Throwable) {
                onFailure(p1.message.toString())
            }
        })
    }}