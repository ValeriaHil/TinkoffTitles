package com.example.lenovo.tinkofftitles.titles

import com.example.lenovo.tinkofftitles.App
import com.example.lenovo.tinkofftitles.Model.Title
import com.example.lenovo.tinkofftitles.api.TinkoffApi
import com.example.lenovo.tinkofftitles.database.AppDB
import io.reactivex.Observable
import javax.inject.Inject

class TitlesRepository {

    @Inject
    lateinit var network: TinkoffApi

    @Inject
    lateinit var database: AppDB

    init {
        App.instance.repositoryComponent.inject(this)
    }

    fun getTitles(): Observable<List<Title>> {
        return getTitlesFromNet().onErrorResumeNext(getTitlesFromDB())
    }

    private fun getTitlesFromDB(): Observable<List<Title>> {
        return database.titleDao().getAll().toObservable()
    }

    private fun getTitlesFromNet(): Observable<List<Title>> {
        return network.news().map {
            it.payload
        }
            .doOnNext {
                if (!it.isNullOrEmpty()) {
                    storeInDB(it)
                }
            }
    }

    private fun storeInDB(titles: List<Title>) {
        Observable.fromCallable { database.titleDao().addAll(titles) }
            .subscribe()
    }
}