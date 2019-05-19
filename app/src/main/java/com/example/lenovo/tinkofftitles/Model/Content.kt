package com.example.lenovo.tinkofftitles.Model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("content")
    val text: String
)

@Entity
data class ContentResponse(
    @PrimaryKey
    val id: Int,
    @SerializedName("payload")
    val content: Content,
    var titleId: Int = 0
)