package com.example.myfinances.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class CdDb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myFinance.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS cd (" +
            "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "accountnumber INTEGER NOT NULL, " +
            "initialbalance REAL NOT NULL, " +
            "currentbalance REAL NOT NULL, " +
            "interestrate REAL NOT NULL);";

    public CdDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cd");
        onCreate(sqLiteDatabase);
    }
}
