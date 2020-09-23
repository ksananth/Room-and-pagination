package com.test.room.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM Article")
    fun getAll(): List<Article>

    @Query("SELECT * FROM Article WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Article>

    @Insert
    fun insertAll(vararg article: Article)

    @Delete
    fun delete(article: Article)

    @Query("DELETE FROM Article")
    fun nukeTable()
}