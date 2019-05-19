package com.example.lenovo.tinkofftitles

import com.example.lenovo.tinkofftitles.api.NetworkModule
import com.example.lenovo.tinkofftitles.titles.TitlesRepository
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface RepositoryComponent {
    fun inject(repo: TitlesRepository)
}