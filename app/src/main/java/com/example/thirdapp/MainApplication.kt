package com.example.thirdapp

import android.app.Application
import com.moengage.core.DataCenter
import com.moengage.core.LogLevel
import com.moengage.core.MoEngage
import com.moengage.core.config.FcmConfig
import com.moengage.core.config.LogConfig
import com.moengage.core.config.NotificationConfig
import com.moengage.inapp.MoEInAppHelper
import com.moengage.pushbase.MoEPushHelper

class MainApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        val moEngage = MoEngage.Builder(this, "04T9ASB4RC2V4L2R6QH3M0PD", DataCenter.DATA_CENTER_3)
            .configureLogs(LogConfig(LogLevel.VERBOSE, true))
            .configureFcm(FcmConfig(true))
            .configureNotificationMetaData(NotificationConfig(R.drawable.small_icon, R.drawable.large_icon))
            .build()


        MoEngage.initialiseDefaultInstance(moEngage)
        MoEPushHelper.getInstance().requestPushPermission(this)
        MoEInAppHelper.getInstance().showInApp(this)
        MoEInAppHelper.getInstance().showNudge(this)


    }
}