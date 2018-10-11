package com.visally.ui.news_list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.visally.R
import kotlinx.android.synthetic.main.item_menu_main.view.*
import kotlinx.android.synthetic.main.item_news_list.view.*

/**
 * Created by Mahdi_ZareTahghighDoost(ZTD)
 *  on 10/10/2018.
 */
class NewsListRecyclerAdapter (): RecyclerView.Adapter<NewsListRecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view =  LayoutInflater.from(p0.context).inflate(R.layout.item_news_list,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.view.txt_item_news_time.text = p1.toString()
        Glide.with(p0.view.context)
                .load("https://www.canadavisa.com/images/vancouver-landscape.jpg")
                .into(p0.view.img_item_news)


    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)


}