package com.test.room.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ArticlesDao {

    @Query("SELECT * FROM Articles")
    fun getAll(): List<Articles>

    @Query("SELECT * FROM Articles WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Articles>

    @Insert
    fun insertAll(vararg article: Articles)

    @Delete
    fun delete(article: Articles)

    @Query("DELETE FROM Articles")
    fun nukeTable()
}