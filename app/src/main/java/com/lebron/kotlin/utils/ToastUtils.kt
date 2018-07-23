package com.lebron.kotlin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.widget.Toast

/**
 * Toast 封装
 */
object ToastUtil {


    private var toast: Toast? = null


    /**
     * 对Context的拓展函数，弹Toast
     */
    @SuppressLint("ShowToast")
    fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT, gravity: Int = Gravity.BOTTOM) {
        if (toast == null) {
            toast = Toast.makeText(this.applicationContext, message, length)
        } else {
            toast!!.setText(message)
            toast?.duration = length

        }
        var yOffset = 0
        if (gravity == Gravity.BOTTOM){
            yOffset = 100

        }
        toast?.setGravity(gravity, 0, yOffset)
        toast?.show()
    }
}
