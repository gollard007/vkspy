package com.example.gollard.kotlinapp.service

import com.vk.sdk.api.VKApi
import com.vk.sdk.api.VKError
import com.vk.sdk.api.VKRequest
import com.vk.sdk.api.VKResponse
import java.util.logging.Handler

/**
 * Created by gollard on 19.12.17.
 */
class Task(h: Handler) : Runnable {

    override fun run() {
        while (true) {
            val request = VKApi.users().get()
            request.executeWithListener(object : VKRequest.VKRequestListener() {
                override fun onComplete(response: VKResponse?) {
                    super.onComplete(response)
                }

                override fun onError(error: VKError?) {
                    super.onError(error)
                }

                override fun attemptFailed(request: VKRequest?, attemptNumber: Int, totalAttempts: Int) {
                    super.attemptFailed(request, attemptNumber, totalAttempts)
                }
            })
        }
    }
}