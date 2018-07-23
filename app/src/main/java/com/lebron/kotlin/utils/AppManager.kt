package com.lebron.kotlin.utils

import android.app.ActivityManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.util.*

/**
 * activity管理类
 */
object AppManager {

    /** 保存 Activity 对象的堆栈 */
    private val activityStack: Stack<AppCompatActivity> = Stack()

    /**
     * 添加 Activity到堆栈
     * @param activity 页面
     */
    fun addActivity(activity: AppCompatActivity) {
        activityStack.add(activity)
    }

    /**
     * 将 Activity 从堆栈移除
     *
     * @param activity Activity 对象
     */
    fun removeActivity(activity: AppCompatActivity) {
        activityStack.remove(activity)
    }

    /**
     * 结束指定 Activity
     * @param activity Activity 对象
     */
    fun finishActivity(activity: AppCompatActivity) {
        if (activityStack.contains(activity)) {
            activity.finish()
        }
    }

    /**
     * 结束指定 Activity
     * @param clazz Activity 类对象
     */
    fun finishActivity(clazz: Class<out AppCompatActivity>) {
        val del: AppCompatActivity? = activityStack.lastOrNull { it.javaClass == clazz }
        del?.finish()
    }

    /**
     *
     * @return 获取栈顶的Activity
     */
    fun peekActivity(): AppCompatActivity {
        return activityStack.peek()
    }

    /**
     * 结束所有的activity
     */
    private fun finishAllActivity(){
        for (activity in activityStack){
            activity.finish()
        }
//        activityStack.clear()
    }

    /**
     * 退出应用程序
     */
    fun exitApp(){
        try {
            finishAllActivity()
            val activityManager  = peekActivity().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
            activityManager.killBackgroundProcesses(peekActivity().packageName)
            System.exit(0)
        } catch (e: Exception) {
            Log.d("AppManager---->>", e.printStackTrace().toString())
        }
    }

    private var lastClickExitTime = 0L

    /**
     * 按两下返回键退出客户端
     */
    fun  isDoubleClickExit() : Boolean {
        val time = System.currentTimeMillis();
        val timeInterval = time - lastClickExitTime
        if (timeInterval in 1..2000){
            return true
        }
        lastClickExitTime = time
        return false
    }
}



