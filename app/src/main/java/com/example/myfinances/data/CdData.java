package com.example.myfinances.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfinances.databases.DbHelper;
import com.example.myfinances.models.Cd;
public class CdData {
    private DbHelper dbHelper;
    private SQLiteDatabase db;

    public CdData(Context context) {
        /// Creates Db
        dbHelper = new DbHelper(context);
    }

    public void open() throws SQLException {
        db = dbHelper.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void insertVals(Cd cd) {
        ContentValues vals = new ContentValues();
        vals.put("accountnumber", cd.getAccountNumber());
        vals.put("initialbalance", cd.getInitialBalance());
        vals.put("currentbalance", cd.getCurrentBalance());
        vals.put("interestrate", cd.getInterestRate());

        db.insert("cd", null, vals);
    }
}
