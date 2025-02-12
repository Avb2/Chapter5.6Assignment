package com.example.myfinances.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.myfinances.databases.DbHelper;
import com.example.myfinances.models.Loan;

public class LoanData {
    private SQLiteDatabase db;
    private DbHelper loanDb;


    public LoanData(Context context){
        this.loanDb = new DbHelper(context);
    }


    public void open() throws SQLException {
        this.db = this.loanDb.getWritableDatabase();
    }

    public void close() throws SQLException {
        this.db.close();
    }

    public void insertVals(Loan loan) throws SQLException{
        try {
            ContentValues vals = new ContentValues();
            vals.put("initialbalance", loan.getInitialBalance());
            vals.put("currentbalance", loan.getCurrentBalance());
            vals.put("accountnumber", loan.getAccountNumber());
            vals.put("interestrate", loan.getInterestRate());
            vals.put("paymentamount", loan.getPaymentAmount());



            this.db.insert("loan", null, vals);
        } catch (Exception e) {
            System.out.println("Error with loan db");
        }
    }
}
