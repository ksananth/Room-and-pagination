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

    @Query(
        "SELECT * FROM user WHERE first_name LIKE :first AND " +
                "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): Articles

    @Insert
    fun insertAll(vararg article: Articles)

    @Delete
    fun delete(article: Articles)

    @Query("DELETE FROM Articles")
    fun nukeTable()
}