package com.example.myfinances;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfinances.databases.CdDb;

public class CdDbHelper {
    private SQLiteDatabase db;
    private CdDb cddb;

    public CdDbHelper(SQLiteDatabase db, CdDb cddb){
        this.db = db;
        this.cddb = cddb;
    }


    public void open() throws SQLException {
        this.db = this.cddb.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.cddb.close();
    }
}