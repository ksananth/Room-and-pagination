package com.test.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Article::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ArticlesDao

    companion object {
        fun create(context: Context): AppDatabase {
            val databaseBuilder =
                Room.databaseBuilder(context, AppDatabase::class.java, "articles.db")
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}