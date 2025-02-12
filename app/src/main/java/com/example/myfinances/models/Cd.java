package com.example.myfinances.models;


/// CDs should be able to store the account number, initial balance, current balance, and interest rate
public class Cd {
    private int accountNumber;
    private double initialBalance;
    private double currentBalance;
    private double interestRate;

    public Cd(int accountNumber, double initialBalance, double currentBalance, double interestRate) {
        this.accountNumber = accountNumber;
        this.initialBalance = initialBalance;
        this.currentBalance = currentBalance;
        this.interestRate = interestRate;
    }

    public int getAccountNumber(){
        return this.accountNumber;
    }

    public double getInitialBalance() {
        return this.initialBalance;
    }

    public double getCurrentBalance() {
        return this.currentBalance;
    }

    public double getInterestRate() {
        return this.interestRate;
    }



}
