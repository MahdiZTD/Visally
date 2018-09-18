package com.visally.infrustructure.data

import android.arch.lifecycle.LiveData
import android.content.Context
import android.content.SharedPreferences
import com.visally.infrustructure.data.local.db.DbHelper
import com.visally.infrustructure.data.local.prefs.PreferencesHelper
import com.visally.infrustructure.data.model.api.NewsByPageResponse
import com.visally.infrustructure.data.model.db.BlogNewsModel
import com.visally.infrustructure.data.remote.ApiHelper
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 7/12/2018.
 */
@Singleton
class VisallyDataManger @Inject constructor(val context: Context,val dbHelper: DbHelper,val preferencesHelper: PreferencesHelper,val apiHelper: ApiHelper):DataManager {
    override fun isNewsBlogEmpty(): Observable<Boolean> {
        return dbHelper.isNewsBlogEmpty()
    }

    override fun loadInitialNews(): Observable<List<BlogNewsModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getNewsApiCall(page: String, perPage: String): Single<List<NewsByPageResponse>> {
        return apiHelper.getNewsApiCall(page,perPage)
    }

    override fun getAllBlogNews(): LiveData<MutableList<BlogNewsModel>> {
        return dbHelper.getAllBlogNews()
    }

}