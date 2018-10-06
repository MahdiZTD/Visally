package com.visally.infrustructure.utils.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 * on 7/12/2018.
 */
interface SchedulersProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}