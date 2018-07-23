package com.lebron.kotlin

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import com.lebron.kotlin.utils.Constants

class BaseApplication : Application() {

    var context: Context? = null

    override fun onCreate() {
        super.onCreate()
        context = this.applicationContext

        getScreenParams()

    }

    /**
     *  获取屏幕参数
     */
    private fun getScreenParams() {
        val displayMetrics  = resources.displayMetrics
        Constants.screenWith = displayMetrics.widthPixels
        Constants.screenHeight = displayMetrics.heightPixels
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

        MultiDex.install(this)
    }
}