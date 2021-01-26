package com.example.a65test.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class MyBbManager(private val context: Context) {
    private val myDbHelper = DbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDB() {

        db = myDbHelper.writableDatabase
    }

    fun insertToBD(
        f_name: String,
        l_name: String,
        birthday: String,
        uri: String,
        kod_spec: String,
        name_spec: String,
    ) {

        val values = ContentValues().apply {
            put(MyDbClass.COLUMN_TABLE_F_Name, f_name)
            put(MyDbClass.COLUMN_TABLE_L_NAME, l_name)
            put(MyDbClass.COLUMN_TABLE_BIRTHDAY, birthday)
            put(MyDbClass.COLUMN_TABLE_URI, uri)
            put(MyDbClass.COLUMN_TABLE_KOD_SPEC, kod_spec)
            put(MyDbClass.COLUMN_TABLE_NAME_SPEC, name_spec)
        }
        db?.insert(MyDbClass.TABLE_NAME, null, values)
    }

    fun readDataDB(): ArrayList<ListData> {


        val dataList = ArrayList<ListData>()

        val cursor = db?.query(
            MyDbClass.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )
        while (cursor?.moveToNext()!!) {
            val dataFName = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_TABLE_F_Name))
            val dataLName = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_TABLE_L_NAME))
            val dataBirthday =
                cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_TABLE_BIRTHDAY))
            val dataUri = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_TABLE_URI))
            val kodSpec = cursor.getInt(cursor.getColumnIndex(MyDbClass.COLUMN_TABLE_KOD_SPEC))
            val nameSpec = cursor.getString(cursor.getColumnIndex(MyDbClass.COLUMN_TABLE_NAME_SPEC))
            val id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            val item = ListData()
            item.f_name = dataFName
            item.l_name = dataLName
            item.birthday = dataBirthday
            item.avatr_url = dataUri
            item.specialty_id = kodSpec
            item.name_spec = nameSpec
            item.id = id
            dataList.add(item)
        }

        cursor.close()
        return dataList
    }

    fun closeDB() {
        myDbHelper.close()
    }

}