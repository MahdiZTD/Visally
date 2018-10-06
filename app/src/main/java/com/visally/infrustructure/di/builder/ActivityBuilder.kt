package com.visally.infrustructure.di.builder

import com.visally.ui.menu_fragment.MenuProvider
import com.visally.ui.news_list.NewsListActivity
import com.visally.ui.news_list.NewsListModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

/*************************************
 *This File Is created By
 * mahdi_TD
 * on
 * 7/14/2018.
 *************************************/

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [NewsListModule::class , MenuProvider::class])
    abstract fun bindMainActivity(): NewsListActivity
}