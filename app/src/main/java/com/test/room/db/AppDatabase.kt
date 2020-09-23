package com.test.room.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Articles::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): ArticlesDao
}