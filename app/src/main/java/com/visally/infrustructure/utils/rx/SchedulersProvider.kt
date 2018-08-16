package com.visally.infrustructure.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 * on 7/12/2018.
 */
interface SchedulersProvider {

    abstract fun computation(): Scheduler

    abstract fun io(): Scheduler

    abstract fun ui(): rx.Scheduler?
}