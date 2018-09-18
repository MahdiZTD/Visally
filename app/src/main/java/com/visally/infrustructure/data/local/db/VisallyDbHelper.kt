package com.visally.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import com.visally.infrustructure.data.model.db.BlogNewsModel
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VisallyDbHelper @Inject constructor (val visallyDatabase: VisallyDatabase):DbHelper {
    override fun isNewsBlogEmpty(): Observable<Boolean> {
        return Observable.fromCallable {visallyDatabase.blogNewsDao().isBlogNewsEmpty()==0}
    }

    override fun getAllBlogNews(): LiveData<MutableList<BlogNewsModel>> {
        return visallyDatabase.blogNewsDao().loadAllNews()
    }
}