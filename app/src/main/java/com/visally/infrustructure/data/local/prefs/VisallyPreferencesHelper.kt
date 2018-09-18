package com.visally.infrustructure.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import com.visally.infrustructure.di.PreferenceInfo
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 7/12/2018.
 */
@Singleton
class VisallyPreferencesHelper @Inject constructor(context: Context, @PreferenceInfo prefFileName:String):PreferencesHelper {
    private var mPref:SharedPreferences

    init {
        mPref = context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE)
    }
}