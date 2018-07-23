package com.lebron.kotlin.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings

/**
 * 意图跳转
 */
object IntentUtils {

    /**
     * 跳转设置系统应用权限界面
     *
     */
    fun intentSetting(context: Context){
        context.startActivity(Intent(Settings.ACTION_SETTINGS))
    }
    /**
     * 跳转到当前应用权限设置界面
     */
    fun intentAppSetting(context: Context){
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.data = Uri.fromParts("package",context.packageName,null)
        context.startActivity(intent)
    }
}