package com.visally.infrustructure.di.component

import android.app.Application
import com.visally.VisallyApp
import com.visally.infrustructure.di.builder.ActivityBuilder
import com.visally.infrustructure.di.module.VisallyModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class , VisallyModule::class,ActivityBuilder::class))
interface VisallyComponent {
    fun inject(app: VisallyApp)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application:Application):Builder
        fun build():VisallyComponent
    }
}