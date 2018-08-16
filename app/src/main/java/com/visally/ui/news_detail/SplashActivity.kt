package com.visally.ui.news_detail

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.visally.R
import com.visally.databinding.ActivitySplashBinding
import com.visally.ui.news_list.NewsListActivity
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    lateinit var binding : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash)
        Observable.timer(3,TimeUnit.SECONDS,Schedulers.io())
                .subscribe {
                    startActivity(Intent(applicationContext,NewsListActivity::class.java))
                }
    }
}
