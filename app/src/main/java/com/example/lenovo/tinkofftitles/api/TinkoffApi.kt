package com.example.lenovo.tinkofftitles.api

import com.example.lenovo.tinkofftitles.Model.ContentResponse
import com.example.lenovo.tinkofftitles.Model.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TinkoffApi {
    @GET("news")
    fun news(): Observable<NewsResponse>

    @GET("news_content")
    fun newsContent(@Query("id") id: Int): Observable<ContentResponse>
}