package com.visally.ui.menu_fragment

import android.arch.lifecycle.ViewModelProvider
import com.visally.ViewModelProviderFactory
import com.visally.infrustructure.data.DataManager
import com.visally.infrustructure.utils.rx.SchedulersProvider
import dagger.Module
import dagger.Provides

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 10/5/2018.
 */
@Module
class MenuModule {

    @Provides
    fun provideMenuViewModel(schedulerProvider: SchedulersProvider, dataManager: DataManager) : MenuViewModel {
        return MenuViewModel(schedulerProvider, dataManager)
    }

}