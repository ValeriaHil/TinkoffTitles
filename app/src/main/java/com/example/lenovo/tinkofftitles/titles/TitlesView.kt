package com.example.lenovo.tinkofftitles.titles

import com.example.lenovo.tinkofftitles.Model.Title
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView

interface TitlesView: MvpLceView<List<Title>> {
    fun onTitleItemClicked(id: Int)
}