package com.example.gollard.kotlinapp.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.gollard.kotlinapp.R
import com.example.gollard.kotlinapp.utils.Constants
import com.example.gollard.kotlinapp.utils.PreferencesHelper
import com.example.gollard.kotlinapp.utils.PreferencesHelper.get
import com.example.gollard.kotlinapp.utils.PreferencesHelper.set
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import kotlinx.android.synthetic.main.activity_login.*
/**
 * Created by gollard on 15.12.17.
 */
class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d("LOGIN", "LOGIN")
        button.setOnClickListener { VKSdk.login(this) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object: VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken?) {
                val intent = Intent(baseContext, MainActivity::class.java)
                val prefs = PreferencesHelper.defaultPreferences(applicationContext)
                prefs[Constants.VK_TOKEN] = res?.accessToken
                startActivity(intent)
            }

            override fun onError(error: VKError?) {
                toast("Error to Log In")
            }
        }
        if(!VKSdk.onActivityResult(requestCode, resultCode, data, callback))
            super.onActivityResult(requestCode, resultCode, data)
    }

    fun AppCompatActivity.toast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

}
