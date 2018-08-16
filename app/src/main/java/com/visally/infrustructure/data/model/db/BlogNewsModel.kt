package com.visally.infrustructure.data.model.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "blog_news")
class BlogNewsModel {

    @PrimaryKey
    var id: Long? = null

    @ColumnInfo(name = "title")
    var title: String? = null

    @ColumnInfo(name = "content")
    var content: String? = null

    @ColumnInfo(name = "header_url")
    var headerUrl: String? = null

    @ColumnInfo(name = "date_modified")
    var date: String? = null

    @ColumnInfo(name = "link")
    var link: String?=null

}