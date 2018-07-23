package com.lebron.kotlin.ui.activity

import com.lebron.kotlin.R
import com.lebron.kotlin.utils.AppManager.exitApp
import com.lebron.kotlin.utils.AppManager.isDoubleClickExit
import com.lebron.kotlin.utils.ToastUtil.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun initData() {
    }

    override fun initView() {
        main_tv.text = getString(R.string.app_name)
        main_tv.setOnClickListener{
            toast("textView被点击了"+count++)
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    var count = 1


    override fun onBackPressed() {
        if (isDoubleClickExit()){
            exitApp()
        }else  toast(getString(R.string.home_exit))
    }


}
