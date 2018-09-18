package com.visally.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import com.visally.infrustructure.data.model.db.BlogNewsModel
import io.reactivex.Observable

interface DbHelper {
    fun getAllBlogNews():LiveData<MutableList<BlogNewsModel>>
    fun isNewsBlogEmpty():Observable<Boolean>
}