package com.example.lenovo.tinkofftitles.titles.content

import com.example.lenovo.tinkofftitles.App
import com.example.lenovo.tinkofftitles.Model.Content
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter

class ContentPresenter : MvpBasePresenter<ContentView>() {
    private val repo = App.instance.contentRepo

    fun loadContent(id: Int) {
        view?.setData(Content(id.toString()))
    }
}