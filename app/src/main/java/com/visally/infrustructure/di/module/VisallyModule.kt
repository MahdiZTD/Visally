package com.visally.infrustructure.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.visally.R
import com.visally.infrustructure.data.DataManager
import com.visally.infrustructure.data.VisallyDataManger
import com.visally.infrustructure.data.local.db.DbHelper
import com.visally.infrustructure.data.local.db.VisallyDatabase
import com.visally.infrustructure.data.local.db.VisallyDbHelper
import com.visally.infrustructure.di.DatabaseInfo
import com.visally.infrustructure.utils.AppConstants
import com.visally.infrustructure.utils.rx.SchedulersProvider
import com.visally.infrustructure.utils.rx.VisallySchedulerProvider
import dagger.Module
import dagger.Provides
import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import java.security.AccessControlContext
import javax.inject.Singleton

@Module
class VisallyModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName:String ,context: Context):VisallyDatabase{
        return Room.databaseBuilder(context,VisallyDatabase::class.java,dbName).fallbackToDestructiveMigration().build()
    }

    @Provides
    @DatabaseInfo
    internal fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }


    @Provides
    @Singleton
    internal fun provideDbHelper(appDbHelper: VisallyDbHelper): DbHelper {
        return appDbHelper
    }


    @Provides
    internal fun provideSchedulerProvider(): SchedulersProvider {
        return VisallySchedulerProvider()
    }

    @Provides
    @Singleton
    fun provideContext(application: Application):Context{
        return application
    }


    @Provides
    @Singleton
    fun provideDataManager(dataManager: VisallyDataManger): DataManager {
        return dataManager
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()}


    @Provides
    @Singleton
    fun provideCalligraphyDefaultConfig(): CalligraphyConfig {
        return CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
    }

}