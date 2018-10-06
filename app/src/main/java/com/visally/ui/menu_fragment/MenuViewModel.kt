package com.visally.ui.menu_fragment

import com.visally.infrustructure.data.DataManager
import com.visally.infrustructure.utils.rx.SchedulersProvider
import com.visally.infrustructure.utils.rx.VisallySchedulerProvider
import com.visally.ui.base.BaseViewModel

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 10/5/2018.
 */

class MenuViewModel constructor(private val schedulerProvider: SchedulersProvider , private val dataManager: DataManager) :BaseViewModel<MenuNavigator>(schedulerProvider, dataManager){

}