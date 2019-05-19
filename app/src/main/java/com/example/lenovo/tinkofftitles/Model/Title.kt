package com.example.lenovo.tinkofftitles.Model

import android.arch.persistence.room.*
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Entity
@Parcelize
data class Title(
    val text: String,
    @PrimaryKey
    val id: Int,
    @SerializedName("publicationDate")
    val publication: Publication
): Parcelable

data class NewsResponse(
    val payload: List<Title>
)

@Parcelize
data class Publication (
    @SerializedName("milliseconds")
    val time: Long
): Parcelable
