package com.visally.infrustructure.data.local.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.visally.infrustructure.data.local.db.dao.BlogNewsDao
import com.visally.infrustructure.data.model.db.BlogNewsModel

@Database(entities = arrayOf(BlogNewsModel::class), version = 1, exportSchema = false)
abstract class VisallyDatabase :RoomDatabase(){
    abstract fun blogNewsDao():BlogNewsDao
}