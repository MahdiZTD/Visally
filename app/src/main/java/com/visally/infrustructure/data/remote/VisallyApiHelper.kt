package com.visally.infrustructure.data.remote

import android.content.Context
import com.visally.infrustructure.data.model.api.NewsByPageResponse
import com.visally.infrustructure.data.model.db.BlogNewsModel
import com.visally.infrustructure.network.NewsInterface
import com.visally.infrustructure.network.RetrofitRepository
import io.reactivex.Single
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 9/16/2018.
 */
class  VisallyApiHelper :ApiHelper{

    override fun getNewsApiCall(page:String,perPage:String): Single<List<NewsByPageResponse>> {
        return RetrofitRepository()
                .getNewsRetrofit()
                .create(NewsInterface::class.java)
                .getNewsByPage(page,perPage)
    }
}