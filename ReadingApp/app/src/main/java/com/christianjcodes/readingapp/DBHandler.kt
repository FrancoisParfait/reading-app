package com.christianjcodes.readingapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHandler(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(MyDB: SQLiteDatabase) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT)")
    }

    override fun onUpgrade(MyDB: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        MyDB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(MyDB)
    }

    fun insertData(username: String?, password: String?): Boolean {
        val MyDB = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val result = MyDB.insert(TABLE_NAME, null, contentValues)
        return if (result == -1L) {
            false
        } else {
            true
        }
    }

    fun checkUsername(username: String): Boolean {
        val MyDB = this.writableDatabase
        val cursor = MyDB.rawQuery("SELECT * FROM users WHERE username = ?", arrayOf(username))
        return if (cursor.count > 0) {
            true
        } else {
            false
        }
    }

    fun checkUsernamePassword(username: String, password: String): Boolean {
        val MyDB = this.writableDatabase
        val cursor = MyDB.rawQuery("SELECT * FROM users WHERE username = ? AND password = ?", arrayOf(username, password))
        return if (cursor.count > 0) {
            true
        } else {
            false
        }
    }

    companion object {
        private const val DB_NAME = "userdb"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "users"
    }
}