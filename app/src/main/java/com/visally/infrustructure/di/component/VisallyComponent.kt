package com.visally.infrustructure.di.component

import android.app.Application
import com.visally.VisallyApp
import com.visally.infrustructure.di.module.VisallyModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(modules = arrayOf(AndroidInjectionModule::class , VisallyModule::class))
interface VisallyComponent {
    fun inject(app: VisallyApp)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application:Application):Builder
        fun build():VisallyComponent
    }
}