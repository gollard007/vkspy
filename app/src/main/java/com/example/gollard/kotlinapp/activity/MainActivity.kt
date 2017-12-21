package com.example.gollard.kotlinapp.activity

import android.app.FragmentManager
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.gollard.kotlinapp.R
import com.example.gollard.kotlinapp.fragments.FriendsFragment
import com.example.gollard.kotlinapp.utils.Constants
import com.example.gollard.kotlinapp.utils.PreferencesHelper
import com.example.gollard.kotlinapp.utils.PreferencesHelper.get
import com.example.gollard.kotlinapp.utils.PreferencesHelper.set
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)
        checkIsLogined()
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val transaction = supportFragmentManager.beginTransaction()
        when (item.itemId) {
            R.id.nav_search-> {

            }
            R.id.nav_friends -> {
                val fragment = FriendsFragment.newInstance()
                transaction.replace(R.id.container, fragment)
            }
            R.id.nav_history -> {

            }
            R.id.nav_settings -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_logout -> {
                logout()
            }
        }
        transaction.commit()
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun checkIsLogined() {
        val prefs: SharedPreferences = PreferencesHelper.defaultPreferences(this)
        val token: String? = prefs[Constants.VK_TOKEN]
        if (token == null || token == "") {
            startLoginActivity()
        }
    }

    fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        startActivity(intent)
        finish()
    }

    fun logout() {
        val prefs = PreferencesHelper.defaultPreferences(this)
        prefs[Constants.VK_TOKEN] = ""
        startLoginActivity()
    }
}
