package com.example.lenovo.tinkofftitles.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.lenovo.tinkofftitles.Model.ContentResponse
import io.reactivex.Single


@Dao
interface ContentDao {
    @Query("SELECT * FROM ContentResponse WHERE titleId = :id")
    fun getContent(id: Int): Single<ContentResponse>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addContent(content: ContentResponse)
}