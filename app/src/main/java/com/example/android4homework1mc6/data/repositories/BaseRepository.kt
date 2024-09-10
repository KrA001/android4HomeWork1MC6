package com.example.android4homework1mc6.data.repositories

import androidx.lifecycle.liveData
import com.example.android4homework1mc6.data.remote.apiservices.AnimeApiService
import javax.inject.Inject

abstract class BaseRepository{

    fun <T> fetchData( data: suspend () -> T) = liveData{
        try {
            emit(data())
        } catch (c : Exception) {
            emit(null)
        }
    }
}