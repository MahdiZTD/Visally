package com.visally.infrustructure.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.visally.infrustructure.data.local.db.VisallyDatabase
import com.visally.infrustructure.di.DatabaseInfo
import dagger.Module
import dagger.Provides
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
    @Singleton
    fun provideContext(application: Application):Context{
        return application
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {return GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()}



//    @Provides
//    @Singleton
//    fun
}