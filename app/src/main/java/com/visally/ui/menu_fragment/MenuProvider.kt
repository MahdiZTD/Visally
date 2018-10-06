package com.visally.ui.menu_fragment

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 10/5/2018.
 */
@Module
public abstract class MenuProvider {
    @ContributesAndroidInjector(modules = arrayOf(MenuModule::class))
    abstract fun provideMenuFragmentFactory(): MenuFragment
}