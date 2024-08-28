package com.opsonin.pushnotificationkotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel("1","1",NotificationManager.IMPORTANCE_DEFAULT)
            getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        }

        val manager: PackageManager = applicationContext.packageManager
        val info: PackageInfo = manager.getPackageInfo(applicationContext.packageName, 0)
        val version = info.versionName
        Log.d("VERSION_NAME",version)
    }
}