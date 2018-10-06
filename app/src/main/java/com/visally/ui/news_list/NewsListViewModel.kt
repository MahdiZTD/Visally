package com.visally.ui.news_list

import android.util.Log
import com.visally.infrustructure.data.DataManager
import com.visally.infrustructure.data.model.db.BlogNewsModel
import com.visally.infrustructure.utils.rx.SchedulersProvider
import com.visally.ui.base.BaseViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 8/12/2018.
 */

class NewsListViewModel(private val schedulerProvider: SchedulersProvider, private val dataManager: DataManager) : BaseViewModel<NewsListNavigator>(schedulerProvider, dataManager) {

    fun loadNewsList(): List<BlogNewsModel> {
//        dataManager.getNewsApiCall("1", "10")
//                .subscribeOn(schedulerProvider.io())
//                .observeOn(schedulerProvider.ui())
//                .subscribe({ newses ->
//                    run {
//                        Log.d("Tag", "message")
//                    }
//                }, { error ->
//                    error.printStackTrace()
//                })
        return emptyList()
    }
}