package com.visally.ui.menu_fragment


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewManager
import com.visally.BR

import com.visally.R
import com.visally.databinding.FragmentMenuBinding
import com.visally.ui.base.BaseFragment
import com.visally.ui.menu_fragment.adapter.MenuRecyclerAdapter
import javax.inject.Inject


/**
 * A Menu Fragment to show app Categories and Navigation's
 *
 */
class MenuFragment : BaseFragment<FragmentMenuBinding,MenuViewModel>(),MenuNavigator {

    @Inject
    lateinit var mMenuViewModel: MenuViewModel

    override val bindingVariable: Int
        get() = BR.menuVm
    override val layoutId: Int
        get() = R.layout.fragment_menu
    override val viewModel: MenuViewModel
        get() = mMenuViewModel

    companion object {
        val TAG = MenuFragment::class.java.simpleName
    }


    lateinit var menuRv:RecyclerView
    private lateinit var mFragmentMenuBinding: FragmentMenuBinding


    fun newInstance(): MenuFragment {
        val args = Bundle()
        val fragment = MenuFragment()
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMenuViewModel.setNavigator(this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFragmentMenuBinding = viewDataBinding
        setUp()
    }
    private fun setUp() {
        menuRv = mFragmentMenuBinding.rvMenuList.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = MenuRecyclerAdapter(context, resources.getStringArray(R.array.menu_array).toMutableList())
        }
    }


}
