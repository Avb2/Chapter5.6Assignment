package com.example.myfinances.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myfinances.models.Loan;

public class LoanDb extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "myFinance.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS loan (" +
            "_id integer primary key autoincrement, " +
            "initialbalance integer not null, " +
            "currentbalance real not null, " +
            "interestrate real not null, " +
            "paymentamount real not null);";


    private SQLiteDatabase db;

    public LoanDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS loan");
    }



    public void open() throws SQLException {
        this.db = this.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.db.close();
    }

    public void insertVals(Loan loan) throws SQLException{
        try {
            ContentValues vals = new ContentValues();
            vals.put("initialbalance", loan.getInitialBalance());
            vals.put("currentbalance", loan.getCurrentBalance());
            vals.put("initialbalance", loan.getInitialBalance());
            vals.put("interestrate", loan.getInterestRate());
            vals.put("paymentamount", loan.getPaymentAmount());

            this.db.insert("loans", null, vals);
        } catch (Exception e) {
            System.out.println("Error with loan db");
        }
    }

}
