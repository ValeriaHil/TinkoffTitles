package com.example.lenovo.tinkofftitles

import android.app.Application
import com.example.lenovo.tinkofftitles.database.DatabaseModule
import com.example.lenovo.tinkofftitles.titles.TitlesRepository
import com.example.lenovo.tinkofftitles.titles.content.ContentRepository

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var titlesRepo: TitlesRepository
    lateinit var contentRepo: ContentRepository
    lateinit var repositoryComponent: RepositoryComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        repositoryComponent = DaggerRepositoryComponent.builder().databaseModule(DatabaseModule(this)).build()
        titlesRepo = TitlesRepository()
        contentRepo = ContentRepository()
    }
}