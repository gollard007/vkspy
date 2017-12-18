package com.example.gollard.kotlinapp.database

import android.provider.BaseColumns
import android.provider.BaseColumns._ID

/**
 * Created by gollard on 14.12.17.
 */
object UsersEntry : BaseColumns {

    val TABLE_NAME = "users"
    val COLUMN_USER_VK_ID = "user_vk_id"
    val COLUMN_USER_VK_NAME = "user_vk_name"
    val COLUMN_USER_ONLINE_TIME = "user_online_time"

    val SQL_CREATE_TABLE = """
        CREATE TABLE $TABLE_NAME (
            $_ID INTEGER PRIMARY KEY,
            $COLUMN_USER_VK_ID INTEGER,
            $COLUMN_USER_VK_NAME TEXT,
            $COLUMN_USER_ONLINE_TIME TEXT
    )"""

    val SQL_DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}