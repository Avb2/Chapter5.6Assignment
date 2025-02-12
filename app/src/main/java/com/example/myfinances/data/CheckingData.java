package com.example.myfinances.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfinances.databases.DbHelper;
import com.example.myfinances.models.CheckingAccount;

public class CheckingData {
    private SQLiteDatabase db;
    private DbHelper checkingDb;

    public CheckingData(Context context){
        checkingDb = new DbHelper(context);
    }


    public void open() throws SQLException {
        this.db = checkingDb.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.db.close();
    }

    public void insertVals(CheckingAccount checkingAccount) throws SQLException {
        try {
            ContentValues vals = new ContentValues();
            vals.put("accountnumber", checkingAccount.getAccountNumber());
            vals.put("currentbalance", checkingAccount.getCurrentBalance());
            this.db.insert("checking", null, vals);
        } catch (Exception e) {
            System.out.println("Error with checking db");
        }
    }
}
