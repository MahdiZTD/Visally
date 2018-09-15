package com.visally.infrustructure.network

import com.visally.infrustructure.data.model.api.NewsByPageResponse
import io.reactivex.Single
import retrofit2.http.*

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 9/11/2018.
 */
interface NewsInterface {

    @GET("/posts?")
    fun getNewsByPage(@Query("page") page:String , @Query("per_page") perPage:String):Single<List<NewsByPageResponse>>

}