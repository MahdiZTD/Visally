package com.visally.infrustructure.data.remote

import com.visally.infrustructure.data.model.db.BlogNewsModel
import io.reactivex.Single

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 9/10/2018.
 */
interface ApiHelper {

    fun getNewsApiCall():Single<List<BlogNewsModel>>
}