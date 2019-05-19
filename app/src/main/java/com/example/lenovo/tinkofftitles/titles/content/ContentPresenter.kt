package com.example.lenovo.tinkofftitles.titles.content

import android.annotation.SuppressLint
import com.example.lenovo.tinkofftitles.App
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ContentPresenter : MvpBasePresenter<ContentView>() {
    private val repo = App.instance.contentRepo

    @SuppressLint("CheckResult")
    fun loadContent(id: Int) {
        repo.getContent(id).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view?.setData(it)
            },
                {
                    view?.showError(it, false)
                })
    }
}