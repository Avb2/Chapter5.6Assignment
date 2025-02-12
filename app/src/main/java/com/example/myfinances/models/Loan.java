package com.example.myfinances.models;


/// Loans should be able to store the account number, initial balance, current balance, payment amount, and interest rate
public class Loan {
    int accountNumber;
    double initialBalance;
    double currentBalance;
    double paymentAmount;
    double interestRate;

    public Loan(int accountNumber, double initialBalance, double currentBalance, double paymentAmount, double interestRate){
        this.accountNumber = accountNumber;
        this.initialBalance = initialBalance;
        this.currentBalance = currentBalance;
        this.paymentAmount = paymentAmount;
        this.interestRate = interestRate;
    }


    /// Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }
}
