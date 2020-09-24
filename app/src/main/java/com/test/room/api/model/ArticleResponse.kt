package com.test.room.api.model

import com.test.room.db.Article

data class ArticleResponse(val status: String, val totalResults: Int, val articles: List<Article>)