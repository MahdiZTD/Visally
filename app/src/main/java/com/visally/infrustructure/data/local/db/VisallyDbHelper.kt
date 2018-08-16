package com.visally.infrustructure.data.local.db

import android.arch.lifecycle.LiveData
import com.visally.infrustructure.data.model.db.BlogNewsModel

class VisallyDbHelper (visallyDatabase: VisallyDatabase):DbHelper {

    override fun getAllBlogNews(): LiveData<MutableList<BlogNewsModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}