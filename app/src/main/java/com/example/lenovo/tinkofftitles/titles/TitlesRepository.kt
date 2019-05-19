package com.example.lenovo.tinkofftitles.titles

import com.example.lenovo.tinkofftitles.App
import com.example.lenovo.tinkofftitles.Model.Title
import com.example.lenovo.tinkofftitles.api.TinkoffApi
import io.reactivex.Observable
import javax.inject.Inject

class TitlesRepository {

    @Inject
    lateinit var network: TinkoffApi

    init {
        App.instance.repositoryComponent.inject(this)
    }

    fun getTitles(): Observable<List<Title>> {
        return getTitlesFromNet()
    }

    private fun getTitlesFromNet(): Observable<List<Title>> {
        return network.news().map {
            it.payload
        }
    }

}