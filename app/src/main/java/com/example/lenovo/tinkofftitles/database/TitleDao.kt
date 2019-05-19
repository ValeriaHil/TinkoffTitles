package com.example.lenovo.tinkofftitles.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.lenovo.tinkofftitles.Model.Title
import io.reactivex.Single

@Dao
interface TitleDao {
    @Query("SELECT * FROM title")
    fun getAll(): Single<List<Title>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAll(titles: List<Title>)
}