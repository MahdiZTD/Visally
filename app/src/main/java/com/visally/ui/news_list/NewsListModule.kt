package com.visally.ui.news_list

import android.arch.lifecycle.ViewModelProvider
import com.visally.ViewModelProviderFactory
import com.visally.infrustructure.data.DataManager
import com.visally.infrustructure.utils.rx.SchedulersProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 9/15/2018.
 */
@Module
class NewsListModule {
    @Provides
    fun provideViewModelProvider(newsListViewModel: NewsListViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(newsListViewModel)
    }

    @Provides
    fun provideNewsListViewModel(dataManager: DataManager, schedulersProvider: SchedulersProvider): NewsListViewModel {
        return NewsListViewModel(schedulersProvider, dataManager)
    }
}