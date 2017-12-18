package com.example.gollard.kotlinapp.database

import android.content.ContentValues
import android.content.Context
import android.util.Log

/**
 * Created by gollard on 14.12.17.
 */

object UsersDBUtil {

    val TAG = "DATABASE"

    fun insertUser(context: Context, vkId: String?, username: String?): Long {
        val db = UsersDbHelper(context).writableDatabase
        val values = ContentValues()
        values.put(UsersEntry.COLUMN_USER_VK_ID, vkId)
        values.put(UsersEntry.COLUMN_USER_VK_NAME, username)
        return db.insert(UsersEntry.TABLE_NAME, UsersEntry.COLUMN_USER_VK_ID, values)
    }

    fun getUsersTime(context: Context, vkId: String?): String? {
        val db = UsersDbHelper(context).readableDatabase
        val projection = arrayOf(UsersEntry.COLUMN_USER_ONLINE_TIME)
        val selection = "${UsersEntry.COLUMN_USER_VK_ID} LIKE ?"
        val selectionArgs = arrayOf(vkId)
        val cursor = db.query(UsersEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, null)
        cursor.moveToFirst()
        while (!cursor.isLast) {
            if (cursor.getString(cursor.getColumnIndex(UsersEntry.COLUMN_USER_VK_ID)) == vkId) {
                cursor.close()
                return cursor.getString(cursor.getColumnIndex(UsersEntry.COLUMN_USER_ONLINE_TIME))
            }
            cursor.moveToNext()
        }
        Log.i(TAG, "No user with this id : $vkId")
        cursor.close()
        return ""
    }

    fun updateUsersTime(context: Context, vkId: String?, newTime: String?): Int {
        val db = UsersDbHelper(context).writableDatabase
        val values = ContentValues()
        val time = getUsersTime(context, vkId) + "," + newTime
        values.put(UsersEntry.COLUMN_USER_ONLINE_TIME, time)
        val selection = "${UsersEntry.COLUMN_USER_VK_ID} LIKE ?"
        val selectionArgs = arrayOf(vkId)
        return db.update(UsersEntry.TABLE_NAME, values, selection, selectionArgs)
    }
}