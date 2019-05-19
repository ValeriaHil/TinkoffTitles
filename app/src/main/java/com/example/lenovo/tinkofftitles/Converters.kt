package com.example.lenovo.tinkofftitles

import android.arch.persistence.room.TypeConverter
import com.example.lenovo.tinkofftitles.Model.Publication

class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromPublication(publication: Publication): Long {
            return publication.time
        }

        @TypeConverter
        @JvmStatic
        fun toPublication(time: Long): Publication {
            return Publication(time)
        }
    }
}