package com.visally.ui.news_list

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.SearchManager
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.View
import android.widget.FrameLayout
import com.visally.BR
import com.visally.R
import com.visally.databinding.ActivityNewsListBinding
import com.visally.ui.base.BaseActivity
import com.visally.ui.menu_fragment.MenuFragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_news_list.*
import java.util.*
import javax.inject.Inject
import android.opengl.ETC1.getWidth
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.animation.*
import com.visally.ui.news_list.adapter.NewsListRecyclerAdapter
import timber.log.Timber


class NewsListActivity : BaseActivity<ActivityNewsListBinding, NewsListViewModel>(), NewsListNavigator, SearchView.OnQueryTextListener, HasSupportFragmentInjector {

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var newsListViewModelFactory: ViewModelProvider.Factory


    override val bindingVariable: Int
        get() = BR.vm
    override val layoutId: Int
        get() = R.layout.activity_news_list
    override val mNewsListViewModel: NewsListViewModel
        get() = ViewModelProviders.of(this,newsListViewModelFactory).get(NewsListViewModel::class.java)

    lateinit var toolbar: Toolbar
    private lateinit var mActivityNewsListBinding: ActivityNewsListBinding // data binding of xml layout file
    private var isMenuVisible: Boolean = false
    private lateinit var mMenu: FrameLayout
    private lateinit var newsListRv:RecyclerView
    private lateinit var rootView: ConstraintLayout
    val menuOpened = ConstraintSet()
    val menuClosed = ConstraintSet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mActivityNewsListBinding = viewDataBinding
        mNewsListViewModel.setNavigator(this)
        setUp()
    }

    private fun setUp() {
        toolbar = mActivityNewsListBinding.toolbarNewsList
        mMenu = mActivityNewsListBinding.frameNewsListMenu
        rootView = mActivityNewsListBinding.constraintNewsList

        menuClosed.clone(rootView)
        menuOpened.clone(this, R.layout.activity_news_list_alt)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        setUpMenu()
        toolbar.setNavigationOnClickListener {
            toggleMenu()
        }
        newsListRv = mActivityNewsListBinding.rvNewsList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = NewsListRecyclerAdapter()
        }
    }

    private fun setUpMenu() {
        supportFragmentManager
                .beginTransaction()
                .disallowAddToBackStack()
                .add(R.id.frame_news_list_menu, MenuFragment().newInstance(), MenuFragment.TAG)
                .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.news_list_menu, menu)
        val menuItem = menu!!.findItem(R.id.search_view_menu_news_list)
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = menuItem.actionView as SearchView
        searchView.queryHint = resources.getString(R.string.search_news_hint)
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(true)
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        return false
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return fragmentDispatchingAndroidInjector
    }

    /**
     * this function is access by view model and view class by
     * news List Navigator and will show and invisible the menu
     */
    override fun toggleMenu() {
        val transition = ChangeBounds()
        transition.interpolator = DecelerateInterpolator()
        transition.duration = 350
        TransitionManager.beginDelayedTransition(rootView,transition)
        val constraint = if(isMenuVisible) {
            toolbar.setNavigationIcon(R.drawable.ic_menu_black)
            menuClosed
        }else {
            toolbar.setNavigationIcon(R.drawable.ic_close_black)
            menuOpened
        }

        constraint.applyTo(rootView)
        isMenuVisible = !isMenuVisible
    }
}
