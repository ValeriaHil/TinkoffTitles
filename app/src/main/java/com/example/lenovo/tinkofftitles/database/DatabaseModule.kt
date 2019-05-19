package com.example.lenovo.tinkofftitles.database

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule(val context: Context) {
    @Provides
    @Singleton
    fun provideDatabase(): AppDB {
        return Room.databaseBuilder(context, AppDB::class.java, "database").build()
    }
}