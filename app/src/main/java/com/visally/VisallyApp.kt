package com.visally

import android.app.Activity
import android.app.Application
import com.visally.infrustructure.di.component.DaggerVisallyComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import javax.inject.Inject

class VisallyApp : Application(),HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var mCalligraphyConfig: CalligraphyConfig

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
         return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerVisallyComponent.builder()
                .application(this)
                .build()
                .inject(this)

        CalligraphyConfig.initDefault(mCalligraphyConfig)

    }
}