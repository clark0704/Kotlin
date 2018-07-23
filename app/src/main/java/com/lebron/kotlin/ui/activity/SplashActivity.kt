package com.lebron.kotlin.ui.activity

/**
 * 启动页
 */
import com.lebron.kotlin.R
import permissions.dispatcher.RuntimePermissions
import permissions.dispatcher.NeedsPermission
import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import com.lebron.kotlin.utils.AppManager.exitApp
import com.lebron.kotlin.utils.IntentUtils
import permissions.dispatcher.OnPermissionDenied

@RuntimePermissions
class SplashActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    private var alertDialog: AlertDialog? = null

    override fun initView() {
        //权限请求
        requestPermissionWithPermissionCheck()
    }

    override fun initData() {
    }

    /**
     * 权限申请成功后执行
     */
    @NeedsPermission(Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    fun requestPermission() {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    @SuppressLint("NeedOnRequestPermissionsResult")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode,grantResults)
    }

    /**
     * 权限拒绝后执行
     */
    @OnPermissionDenied(Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    fun onPermissionDenied() {

        alertDialog =  AlertDialog.Builder(this)
                .setTitle(R.string.requests_for_permissions)
                .setMessage(R.string.requests_for_permissions_hint)
                .setPositiveButton("设置") { _, _ ->
                    IntentUtils.intentAppSetting(this)
                }
                .setNegativeButton("退出") { _, _ ->
                    exitApp()
                }
                .create()

                alertDialog?.show()
    }
}

