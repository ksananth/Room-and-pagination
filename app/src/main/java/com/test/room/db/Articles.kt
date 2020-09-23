package com.test.room.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Articles(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "urlToImage") val urlToImage: String
)