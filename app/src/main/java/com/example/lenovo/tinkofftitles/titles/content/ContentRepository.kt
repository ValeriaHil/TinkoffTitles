package com.example.lenovo.tinkofftitles.titles.content

import com.example.lenovo.tinkofftitles.App
import com.example.lenovo.tinkofftitles.Model.Content
import com.example.lenovo.tinkofftitles.Model.ContentResponse
import com.example.lenovo.tinkofftitles.Model.Title
import com.example.lenovo.tinkofftitles.api.TinkoffApi
import com.example.lenovo.tinkofftitles.database.AppDB
import io.reactivex.Observable
import javax.inject.Inject

class ContentRepository {

    @Inject
    lateinit var network: TinkoffApi

    @Inject
    lateinit var database: AppDB

    init {
        App.instance.repositoryComponent.inject(this)
    }

    fun getContent(id: Int): Observable<Content> {
        return getContentFromNet(id).onErrorResumeNext(getContentFromDB(id))
    }

    private fun getContentFromDB(id: Int): Observable<Content> {
        return database.contentDao().getContent(id).map { it.content }.toObservable()
    }

    private fun getContentFromNet(id: Int): Observable<Content> {
        return network.newsContent(id)
            .doOnNext { if (it != null) storeInDB(it, id) }
            .map { it.content }
    }

    private fun storeInDB(content: ContentResponse, id: Int) {
        content.titleId = id
        Observable.fromCallable { database.contentDao().addContent(content) }
            .subscribe()
    }
}