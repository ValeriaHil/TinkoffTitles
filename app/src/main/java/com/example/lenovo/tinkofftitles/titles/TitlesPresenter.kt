package com.example.lenovo.tinkofftitles.titles

import com.example.lenovo.tinkofftitles.Model.Title
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter

class TitlesPresenter: MvpBasePresenter<TitlesView>() {

    fun loadTitles() {
        val list = ArrayList<Title>()
        list.add(Title("Hello"))
        list.add(Title("Hey"))
        view?.setData(list)
    }
}