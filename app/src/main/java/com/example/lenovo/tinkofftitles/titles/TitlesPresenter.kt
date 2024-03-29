package com.example.lenovo.tinkofftitles.titles

import android.annotation.SuppressLint
import com.example.lenovo.tinkofftitles.App
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class TitlesPresenter : MvpBasePresenter<TitlesView>() {
    private val repo = App.instance.titlesRepo

    @SuppressLint("CheckResult")
    fun loadTitles() {
        repo.getTitles().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val list = it.sortedBy { item -> item.publication.time }
                view?.setData(list.asReversed())
            },
                {
                    view?.showError(it, false)
                })
    }

    fun onItemClicked(id: Int) {
        view?.onTitleItemClicked(id)
    }
}