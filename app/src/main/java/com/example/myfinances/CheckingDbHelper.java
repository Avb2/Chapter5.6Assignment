package com.example.myfinances;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfinances.databases.CheckingDb;
import com.example.myfinances.databases.LoanDb;

public class CheckingDbHelper {
    private SQLiteDatabase db;
    private CheckingDb checkingDb;

    public CheckingDbHelper(SQLiteDatabase db, CheckingDb checkingDb){
        this.db = db;
        this.checkingDb = checkingDb;
    }


    public void open() throws SQLException {
        this.db = this.checkingDb.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.checkingDb.close();
    }
}