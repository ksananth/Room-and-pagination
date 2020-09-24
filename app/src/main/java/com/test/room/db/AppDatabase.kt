package com.test.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.test.room.ioThread

@Database(entities = [Article::class], version = 4)
abstract class AppDatabase : RoomDatabase() {

    abstract fun articlesDao(): ArticlesDao

    companion object {

        private var instance: AppDatabase? = null

        @Synchronized
        fun create(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "AppDatabase")
                    .fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            fillInDb(context.applicationContext)
                        }
                    }).build()
            }
            return instance!!
        }


        private fun fillInDb(context: Context) {
            // inserts in Room are executed on the current thread, so we insert in the background
            ioThread {
                create(context).articlesDao().insert(
                    DATA.map {
                        Article(
                            uid = it.uid,
                            author = it.author,
                            title = it.title,
                            urlToImage = it.urlToImage
                        )
                    })
            }
        }
    }
}


private val DATA = arrayListOf(
    Article(1, "Ananth", "Life of Pie", "https://img.icons8.com/material/4ac144/256/user-male.png")
)