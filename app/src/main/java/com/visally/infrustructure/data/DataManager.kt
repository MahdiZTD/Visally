package com.visally.infrustructure.data

import com.visally.infrustructure.data.local.db.DbHelper
import com.visally.infrustructure.data.local.prefs.PreferencesHelper
import com.visally.infrustructure.data.model.db.BlogNewsModel
import com.visally.infrustructure.data.remote.ApiHelper
import io.reactivex.Observable
import java.util.*

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 7/12/2018.
 */
interface DataManager :ApiHelper,DbHelper,PreferencesHelper{
    fun loadInitialNews():Observable<List<BlogNewsModel>>
}