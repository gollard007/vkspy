package com.example.gollard.kotlinapp.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.*

/**
 * Created by gollard on 13.12.17.
 */
class MainService : Service() {
    override fun onBind(intent: Intent?): IBinder {
        TODO("not implemented")
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        var task = Runnable {
            Log.d("Time from thread", Date().time.toString())
        }
        return Service.START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}