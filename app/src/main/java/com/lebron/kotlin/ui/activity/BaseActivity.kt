package com.lebron.kotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.gyf.barlibrary.ImmersionBar
import com.lebron.kotlin.R
import com.lebron.kotlin.utils.AppManager

abstract class BaseActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName
    open var immersionBar:ImmersionBar? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        AppManager.addActivity(this)

        if (isImmersionBar()) {
            immersionBar = ImmersionBar.with(this)
            initImersionBar()
        }


        initView()

        initData()
    }

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 获取资源id
     */
    abstract fun getLayoutId() : Int

    /**
     * 初始化组件
     */
    abstract fun initView()

    override fun onDestroy() {
        super.onDestroy()

        immersionBar?.destroy()
        AppManager.removeActivity(this)
    }

    open fun isImmersionBar() : Boolean =true//是否使用沉浸式状态栏
    open fun isBlack() : Boolean = false//状态栏字体颜色设置

    private fun initImersionBar(){
        if (isBlack())immersionBar?.statusBarDarkFont(true,0.6f)
                ?.flymeOSStatusBarFontColor(R.color.black)
                ?.init()
        else immersionBar?.statusBarDarkFont(false,0.6f)
                ?.flymeOSStatusBarFontColor(R.color.white)
                ?.init()
    }
}