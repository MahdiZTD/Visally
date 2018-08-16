package com.visally.infrustructure.utils.rx

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import rx.android.schedulers.AndroidSchedulers

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 * on 7/12/2018.
 */
class VisallySchedulerProvider :SchedulersProvider{
    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): rx.Scheduler? {
        return AndroidSchedulers.mainThread()
    }
}