package com.hardikmahant.jobschedulersample.foreground_service

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class FSApplication: Application() {

    companion object {
        const val CHANNEL_ID = "my_app_service_channel"
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                CHANNEL_ID,
                "my_app_notification_channel",
                NotificationManager.IMPORTANCE_DEFAULT
            )

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}