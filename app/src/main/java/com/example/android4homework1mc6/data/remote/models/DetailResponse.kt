package com.example.android4homework2.data.remote.models

import com.example.android4homework1mc6.data.remote.models.DataItem
import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("data")
    val data: DataItem
)
