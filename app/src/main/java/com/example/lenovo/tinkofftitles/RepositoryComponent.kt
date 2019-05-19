package com.example.lenovo.tinkofftitles

import com.example.lenovo.tinkofftitles.api.NetworkModule
import com.example.lenovo.tinkofftitles.database.DatabaseModule
import com.example.lenovo.tinkofftitles.titles.TitlesRepository
import com.example.lenovo.tinkofftitles.titles.content.ContentRepository
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class, DatabaseModule::class])
@Singleton
interface RepositoryComponent {
    fun inject(repo: TitlesRepository)
    fun inject(repo: ContentRepository)
}