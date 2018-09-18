package com.visally.infrustructure.data.local.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.visally.infrustructure.data.model.db.BlogNewsModel

@Dao
interface BlogNewsDao {

    @Query("SELECT * FROM blog_news")
    fun loadAllNews(): LiveData<MutableList<BlogNewsModel>>

    @Query("SELECT COUNT(*) FROM blog_news ")
    fun isBlogNewsEmpty():Int


}