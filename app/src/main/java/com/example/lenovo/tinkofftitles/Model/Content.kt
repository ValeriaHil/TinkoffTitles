package com.example.lenovo.tinkofftitles.Model

import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("content")
    val text: String
)

data class ContentResponse(
    @SerializedName("payload")
    val content: Content
)