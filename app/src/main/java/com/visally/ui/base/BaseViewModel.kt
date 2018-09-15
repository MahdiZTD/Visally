package com.visally.ui.base

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableBoolean
import com.visally.infrustructure.data.DataManager
import com.visally.infrustructure.utils.rx.SchedulersProvider
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

abstract class BaseViewModel<N> constructor(schedulerProvider:SchedulersProvider , dataManager: DataManager):ViewModel() {

    val mIsLoading = ObservableBoolean(false)
    var compositeDisposable:CompositeDisposable= CompositeDisposable()
    var mNavigator: WeakReference<N>? = null


    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

}