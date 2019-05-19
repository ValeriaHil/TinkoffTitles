package com.example.lenovo.tinkofftitles.Model

data class Title(
    val text: String,
    val id: Int
)

data class NewsResponse(
    val payload: List<Title>
)