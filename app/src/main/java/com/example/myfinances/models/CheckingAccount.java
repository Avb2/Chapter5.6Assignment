package com.example.myfinances.models;


/// Checking accounts should be able to store the account number and current balance.
public class CheckingAccount {
    int accountNumber;
    double currentBalance;

    public CheckingAccount(int accountNumber, double currentBalance) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }

    /// Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }
}
