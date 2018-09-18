package com.visally.ui.news_list

import android.app.Activity
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import com.visally.BR
import com.visally.R
import com.visally.databinding.ActivityNewsListBinding
import com.visally.ui.base.BaseActivity
import javax.inject.Inject

class NewsListActivity: BaseActivity<ActivityNewsListBinding, NewsListViewModel>(), NewsListNavigator {

    @Inject
    lateinit var newsListViewModelFactory: ViewModelProvider.Factory

    private lateinit var mActivityNewsListBinding: ActivityNewsListBinding

    override val bindingVariable: Int
        get() = BR.vm
    override val layoutId: Int
        get() = R.layout.activity_news_list
    override val mNewsListViewModel: NewsListViewModel
        get() = ViewModelProviders.of(this,newsListViewModelFactory).get(NewsListViewModel::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityNewsListBinding = viewDataBinding
        mNewsListViewModel.setNavigator(this)
        mNewsListViewModel.loadNewsList()
    }
}
