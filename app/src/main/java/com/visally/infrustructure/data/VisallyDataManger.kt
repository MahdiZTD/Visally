package com.visally.infrustructure.data

import android.content.Context
import com.visally.infrustructure.data.local.db.DbHelper
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 7/12/2018.
 */
@Singleton
class VisallyDataManger @Inject constructor(context: Context, dbHelper: DbHelper ):DataManager {

}