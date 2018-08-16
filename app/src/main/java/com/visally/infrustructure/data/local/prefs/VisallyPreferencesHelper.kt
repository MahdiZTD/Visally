package com.visally.infrustructure.data.local.prefs

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 7/12/2018.
 */
class VisallyPreferencesHelper constructor(context: Context,prefFileName:String):PreferencesHelper {
    private lateinit var mPref:SharedPreferences

    init {
        mPref = context.getSharedPreferences(prefFileName,Context.MODE_PRIVATE)
    }
}