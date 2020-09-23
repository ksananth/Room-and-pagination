package com.test.room.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM Article")
    fun getAll(): PagingSource<Int, Article>

    @Query("SELECT * FROM Article WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): PagingSource<Int, Article>

    @Insert
    fun insertAll(vararg article: Article)

    @Delete
    fun delete(article: Article)

    @Query("DELETE FROM Article")
    fun nukeTable()
}