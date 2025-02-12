package com.example.myfinances.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myFinance.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_CD = "CREATE TABLE IF NOT EXISTS cd (" +
            "_id integer primary key autoincrement, " +
            "accountnumber integer not null, " +
            "initialbalance real not null, " +
            "currentbalance real not null, " +
            "interestrate real not null);";

    private static final String CREATE_TABLE_CHECKING = "CREATE TABLE IF NOT EXISTS checking (" +
            "_id integer primary key autoincrement, " +
            "accountnumber integer not null, " +
            "currentbalance real not null);";

    private static final String CREATE_TABLE_LOANS = "CREATE TABLE IF NOT EXISTS loan (" +
            "_id integer primary key autoincrement, " +
            "accountnumber integer not null, " +
            "initialbalance integer not null, " +
            "currentbalance real not null, " +
            "interestrate real not null, " +
            "paymentamount real not null);";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_CHECKING);
        sqLiteDatabase.execSQL(CREATE_TABLE_CD);
        sqLiteDatabase.execSQL(CREATE_TABLE_LOANS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cd");
        onCreate(sqLiteDatabase);
    }
}
