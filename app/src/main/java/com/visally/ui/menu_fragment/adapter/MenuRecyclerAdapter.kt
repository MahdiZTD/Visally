package com.visally.ui.menu_fragment.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.visally.R
import kotlinx.android.synthetic.main.item_menu_main.view.*
import java.util.zip.Inflater

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 10/9/2018.
 */
class MenuRecyclerAdapter (var context: Context , var menuList:MutableList<String>): RecyclerView.Adapter<MenuRecyclerAdapter.ViewHolder>() {

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MenuRecyclerAdapter.ViewHolder {
        val textView = LayoutInflater.from(p0.context).inflate(R.layout.item_menu_main,p0,false) as TextView
        return ViewHolder(textView)
    }

    override fun getItemCount(): Int {
        return menuList.size
    }

    override fun onBindViewHolder(p0: MenuRecyclerAdapter.ViewHolder, p1: Int) {
        p0.textView.text = menuList[p1]
    }
}