package com.visally.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import com.visally.infrustructure.data.model.db.BlogNewsModel

interface DbHelper {
    fun getAllBlogNews():LiveData<MutableList<BlogNewsModel>>
}