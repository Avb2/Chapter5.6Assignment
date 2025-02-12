package com.example.myfinances;


import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfinances.databases.CdDb;
import com.example.myfinances.databases.LoanDb;

public class LoanDbHelper {
    private SQLiteDatabase db;
    private LoanDb loanDb;

    public LoanDbHelper(SQLiteDatabase db, LoanDb loanDb){
        this.db = db;
        this.loanDb = loanDb;
    }


    public void open() throws SQLException {
        this.db = this.loanDb.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.loanDb.close();
    }
}