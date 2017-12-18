package com.example.gollard.kotlinapp.utils

import android.content.Context
import android.util.Log
import com.vk.sdk.util.VKUtil

/**
 * Created by gollard on 13.12.17.
 */

object Util{
    val TAG = "UTIL"

    fun logKeys(context: Context) {
        val fingerprints = VKUtil.getCertificateFingerprint(context, context.packageName)
        for (key in fingerprints)
            Log.d(TAG, key)
    }
}
