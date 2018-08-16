package com.visally.ui.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 8/12/2018.
 */
abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(position: Int)
}
