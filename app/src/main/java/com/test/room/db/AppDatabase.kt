package com.test.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Articles::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ArticlesDao

    companion object {
        fun create(context: Context, useInMemory: Boolean): AppDatabase {
            val databaseBuilder =
                Room.databaseBuilder(context, AppDatabase::class.java, "articles.db")
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}