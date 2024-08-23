package com.example.android4homework1mc6.data.remote.models

import com.example.android4homework2.data.remote.models.Links
import com.google.gson.annotations.SerializedName

data class DataItem(
    @SerializedName("links")
    val links: Links,
    @SerializedName("attributes")
    val attributes: Attributes,
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)