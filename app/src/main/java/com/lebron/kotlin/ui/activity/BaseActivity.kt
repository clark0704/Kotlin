package com.lebron.kotlin.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lebron.kotlin.utils.AppManager

abstract class BaseActivity : AppCompatActivity() {

    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(getLayoutId())

        AppManager.addActivity(this)

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
        AppManager.removeActivity(this)
    }
}