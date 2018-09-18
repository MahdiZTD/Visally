package com.visally.infrustructure.network

import android.content.Context
import com.visally.infrustructure.data.remote.ApiEndPoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 9/11/2018.
 */
class RetrofitRepository {
    val defaultOkHttpRequestTimeoutSeconds = 10L
    val defaultOkHttpResponseTimeoutSeconds = 10L
    val defaultOkHttpTimeoutSeconds = 10L


    fun getNewsRetrofit():Retrofit{
        val httpClient =OkHttpClient.Builder()
//                .addInterceptor(ChuckInterceptor(context))
                .readTimeout(defaultOkHttpRequestTimeoutSeconds, TimeUnit.SECONDS)
                .writeTimeout(defaultOkHttpResponseTimeoutSeconds, TimeUnit.SECONDS)
                .connectTimeout(defaultOkHttpTimeoutSeconds, TimeUnit.SECONDS)
                .build()

        return Retrofit.Builder()
                .baseUrl(ApiEndPoint.ENDPOINT_NEWS)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}