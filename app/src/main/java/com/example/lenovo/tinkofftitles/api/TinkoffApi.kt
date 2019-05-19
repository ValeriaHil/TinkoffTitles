package com.example.lenovo.tinkofftitles.api

import com.example.lenovo.tinkofftitles.Model.NewsResponse
import com.example.lenovo.tinkofftitles.Model.Title
import io.reactivex.Observable
import retrofit2.http.GET

interface TinkoffApi {
    @GET("news")
    fun news(): Observable<NewsResponse>
}