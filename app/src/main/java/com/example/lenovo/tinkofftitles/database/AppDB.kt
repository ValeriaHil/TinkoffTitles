package com.example.lenovo.tinkofftitles.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.example.lenovo.tinkofftitles.Converters
import com.example.lenovo.tinkofftitles.Model.ContentResponse
import com.example.lenovo.tinkofftitles.Model.Title

@Database(entities = [Title::class, ContentResponse::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDB : RoomDatabase() {
    abstract fun titleDao(): TitleDao
    abstract fun contentDao(): ContentDao
}