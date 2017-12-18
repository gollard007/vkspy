package com.example.gollard.kotlinapp

import android.app.Application
import com.example.gollard.kotlinapp.utils.Util
import com.vk.sdk.VKSdk

/**
 * Created by gollard on 2.8.17.
 */

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(applicationContext)
        Util.logKeys(this)
    }
}