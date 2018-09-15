package com.visally

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 9/15/2018.
 */
class ViewModelProviderFactory<V : Any>(var viewModel: V) :ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModel.javaClass)) {
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}