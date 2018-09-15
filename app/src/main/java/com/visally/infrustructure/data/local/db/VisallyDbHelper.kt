package com.visally.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import com.visally.infrustructure.data.model.db.BlogNewsModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VisallyDbHelper @Inject constructor (visallyDatabase: VisallyDatabase):DbHelper {

    override fun getAllBlogNews(): LiveData<MutableList<BlogNewsModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}