package com.bangkit.glendjetpack1.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangkit.glendjetpack1.data.FilmEntity
import com.bangkit.glendjetpack1.data.ShowEntity

@Database(entities = [FilmEntity::class, ShowEntity::class], version = 1, exportSchema = false)
abstract class ContentDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDao

    companion object {

        @Volatile
        private var INSTANCE: ContentDatabase? = null

        fun getInstance(context: Context): ContentDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ContentDatabase::class.java,
                    "content.db"
                ).build()
            }
    }

}