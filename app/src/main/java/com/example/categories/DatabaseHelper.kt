package com.example.categories

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream


class DatabaseHelper(
    private val context: Context?,
) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {



    override fun onCreate(db: SQLiteDatabase?) {

    }

    @Throws(IOException::class)
    fun createDataBase() {
        val dbExist: Boolean = databaseExists()
        if (!dbExist) {
            this.readableDatabase
            try {
                copyLocalDatabase()
            } catch (e: IOException) {
                Log.e("tle99 - create", e.message!!)
            }
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun getActivities(): List<String>? {
        val listUsers: MutableList<String> = ArrayList()
        val db = this.writableDatabase
        val c: Cursor?
        try {
            c = db.rawQuery("SELECT * FROM $PUBLIC_ACTIVITIES", null)
            if (c == null) return null
            var name: String
            c.moveToFirst()
            do {
                name = c.getString(1)
                listUsers.add(name)
                println(name)
            } while (c.moveToNext())
            c.close()
        } catch (e: java.lang.Exception) {
            Log.e("tle99", e.message!!)
        }
        db.close()
        return listUsers
    }

    private fun databaseExists(): Boolean {
        var tempDB: SQLiteDatabase? = null
        try {
            val myPath = DB_PATH + DB_NAME
            tempDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE)
        } catch (e: SQLiteException) {
            Log.e("tle99 - check", e.message.toString())
        }
        tempDB?.close()
        return if (tempDB != null) true else false
    }

    @Throws(IOException::class)
    private fun copyLocalDatabase() {
        try {
            if (context!=null) {
                val myInput: InputStream = context.assets.open(DB_NAME)
                val outputFileName = DB_PATH + DB_NAME
                val myOutput: OutputStream = FileOutputStream(outputFileName)
                val buffer = ByteArray(1024)
                var length: Int
                while (myInput.read(buffer).also { length = it } > 0) {
                    myOutput.write(buffer, 0, length)
                }
                myOutput.flush()
                myOutput.close()
                myInput.close()
            }
        } catch (e: Exception) {
            Log.e("tle99 - copyDatabase", e.message!!)
        }
    }

    companion object{
        var DB_PATH = "/data/data/com.example.categories/databases/"
        var DB_NAME = "database.db"
        val DB_VERSION = 1
        val PUBLIC_ACTIVITIES = "PUBLIC_ACTIVITIES"
        val db: SQLiteDatabase? = null
    }
}