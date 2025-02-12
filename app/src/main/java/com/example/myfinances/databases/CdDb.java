package com.example.myfinances.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myfinances.models.Cd;


public class CdDb extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "myFinance.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS cd (" +
            "_id integer primary key autoincrement," +
            "accountnumber integer not null, " +
            "initialbalance real not null, " +
            "currentbalance real not null, " +
            "interestrate real not null);";

    private SQLiteDatabase db;

    public CdDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cd");
        this.onCreate(this.db);
    }


    public void open() throws SQLException {
        this.db = this.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.db.close();
    }

    public void insertVals(Cd cd) throws SQLException{
        try {
            ContentValues vals = new ContentValues();
            vals.put("accountnumber", cd.getAccountNumber());
            vals.put("initialbalance", cd.getInitialBalance());
            vals.put("currentbalance", cd.getCurrentBalance());
            vals.put("interestrate", cd.getInterestRate());

            this.db.insert("cd", null, vals);
        } catch (Exception e) {

        }
}
}