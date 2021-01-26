package com.example.a65test.db

import android.provider.BaseColumns

object MyDbClass : BaseColumns {

    const val TABLE_NAME = "my_prof"
    const val COLUMN_TABLE_F_Name = "f_name"
    const val COLUMN_TABLE_L_NAME = "l_name"
    const val COLUMN_TABLE_BIRTHDAY = "birthday"
    const val COLUMN_TABLE_URI = "uri"
    const val COLUMN_TABLE_KOD_SPEC = "kod_spec"
    const val COLUMN_TABLE_NAME_SPEC = "name_spec"
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "MyProf.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            " ${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_TABLE_F_Name TEXT, $COLUMN_TABLE_L_NAME TEXT,$COLUMN_TABLE_BIRTHDAY TEXT," +
            "$COLUMN_TABLE_URI TEXT, $COLUMN_TABLE_KOD_SPEC TEXT, $COLUMN_TABLE_NAME_SPEC TEXT)"

    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}