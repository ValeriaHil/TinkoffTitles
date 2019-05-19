package com.example.lenovo.tinkofftitles.titles.content

import com.example.lenovo.tinkofftitles.App
import com.example.lenovo.tinkofftitles.Model.Content
import com.example.lenovo.tinkofftitles.api.TinkoffApi
import io.reactivex.Observable
import javax.inject.Inject

class ContentRepository {

    @Inject
    lateinit var network: TinkoffApi

    init {
        App.instance.repositoryComponent.inject(this)
    }

    fun getContent(id: Int): Observable<Content> {
        return getContentFromNet(id)
    }

    private fun getContentFromNet(id: Int): Observable<Content> {
        return network.newsContent(id).map { it.content }
    }
}