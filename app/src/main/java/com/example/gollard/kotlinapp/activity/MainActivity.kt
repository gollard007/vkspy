package com.example.gollard.kotlinapp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.gollard.kotlinapp.R
import com.example.gollard.kotlinapp.utils.Constants
import com.example.gollard.kotlinapp.utils.PreferencesHelper
import com.example.gollard.kotlinapp.utils.PreferencesHelper.get
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by gollard on 15.12.17.
 */

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MAIN", "MAIN")
        setContentView(R.layout.activity_main)
        showToken()
    }

    fun showToken() {
        val prefs = PreferencesHelper.defaultPreferences(this)
        val token: String? = prefs[Constants.VK_TOKEN]
        greeting_text.setText(token)
    }
}