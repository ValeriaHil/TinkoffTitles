package com.example.lenovo.tinkofftitles

import android.app.Application
import com.example.lenovo.tinkofftitles.database.DatabaseModule
import com.example.lenovo.tinkofftitles.titles.TitlesRepository

class App : Application() {
    companion object {
        lateinit var instance: App
    }

    lateinit var titlesRepo: TitlesRepository
    lateinit var repositoryComponent: RepositoryComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        repositoryComponent = DaggerRepositoryComponent.builder().databaseModule(DatabaseModule(this)).build()
        titlesRepo = TitlesRepository()
    }
}