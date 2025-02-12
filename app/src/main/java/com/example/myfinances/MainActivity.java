package com.example.myfinances;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myfinances.databases.CdDb;
import com.example.myfinances.databases.CheckingDb;
import com.example.myfinances.databases.LoanDb;
import com.example.myfinances.helpers.CdData;
import com.example.myfinances.helpers.CheckingData;
import com.example.myfinances.helpers.LoanData;
import com.example.myfinances.models.Cd;
import com.example.myfinances.models.CheckingAccount;
import com.example.myfinances.models.Loan;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initState();
        radioGroupOnChange();

        saveButtonInnit();
        cancelButtonInnit();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void initState(){
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        EditText paymentAmountField = findViewById(R.id.paymentAmountEditText);
        radioGroup.check(R.id.cdRadio);
        paymentAmountField.setEnabled(false);
    }

    void radioGroupOnChange(){
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                /// Radio Buttons
                RadioButton cdButton = findViewById(R.id.cdRadio);
                RadioButton loanButton = findViewById(R.id.loanRadio);
                RadioButton checkingButton = findViewById(R.id.checkingRadio);

                /// Text Fields
                EditText accountNumberField = findViewById(R.id.accountNumberEditText);
                EditText initialBalanceField = findViewById(R.id.initialBalanceEditText);
                EditText currentBalanceField = findViewById(R.id.currentBalanceEditText);
                EditText interestRateField = findViewById(R.id.interestRateEditText);
                EditText paymentAmountField = findViewById(R.id.paymentAmountEditText);


                if (cdButton.isChecked()){
                    accountNumberField.setEnabled(true);
                    initialBalanceField.setEnabled(true);
                    currentBalanceField.setEnabled(true);
                    interestRateField.setEnabled(true);

                    paymentAmountField.setEnabled(false);
                } else if (loanButton.isChecked()) {
                    accountNumberField.setEnabled(true);
                    initialBalanceField.setEnabled(true);
                    currentBalanceField.setEnabled(true);
                    interestRateField.setEnabled(true);
                    paymentAmountField.setEnabled(true);
                } else if (checkingButton.isChecked()) {
                    accountNumberField.setEnabled(true);
                    initialBalanceField.setEnabled(false);
                    currentBalanceField.setEnabled(true);
                    interestRateField.setEnabled(false);
                    paymentAmountField.setEnabled(false);
                }

            }
        });
    }


    void saveButtonInnit() {
        Button saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// Radio Buttons
                RadioButton cdButton = findViewById(R.id.cdRadio);
                RadioButton loanButton = findViewById(R.id.loanRadio);
                RadioButton checkingButton = findViewById(R.id.checkingRadio);

                /// Text Fields
                EditText accountNumberField = findViewById(R.id.accountNumberEditText);
                EditText initialBalanceField = findViewById(R.id.initialBalanceEditText);
                EditText currentBalanceField = findViewById(R.id.currentBalanceEditText);
                EditText interestRateField = findViewById(R.id.interestRateEditText);
                EditText paymentAmountField = findViewById(R.id.paymentAmountEditText);

                /// Extracted Vals
                int accountNumber = 0;
                if (!accountNumberField.getText().toString().isEmpty()){
                    accountNumber = Integer.parseInt(accountNumberField.getText().toString());
                }
                double initialbalance = 0.0;
                if (!initialBalanceField.getText().toString().isEmpty()) {
                     initialbalance = Double.parseDouble(initialBalanceField.getText().toString());
                }
                double currentBalance = 0.0;
                if (!currentBalanceField.getText().toString().isEmpty()){
                    currentBalance = Double.parseDouble(currentBalanceField.getText().toString());
                }
                double interestRate = 0.0;
                if (!interestRateField.getText().toString().isEmpty()){
                    interestRate = Double.parseDouble(interestRateField.getText().toString());
                }
                double paymentAmount = 0.0;
                if (!paymentAmountField.getText().toString().isEmpty()) {
                    paymentAmount = Double.parseDouble(paymentAmountField.getText().toString());
                }

                /// Value insert
                if (cdButton.isChecked()){
                    try {
                        Cd cd = new Cd(
                                accountNumber,
                                initialbalance,
                                currentBalance,
                                interestRate
                        );
                        /// Handles data management (inserts)
                        CdData cdData = new CdData(MainActivity.this);

                        cdData.open();
                        cdData.insertVals(cd);
                        cdData.close();

                    } catch (Exception e) {
                        System.out.println("Error with cd db");
                    }
                } else if (loanButton.isChecked()) {
                    Loan loan = new Loan(
                            accountNumber,
                            initialbalance,
                            currentBalance,
                            paymentAmount,
                            interestRate
                    );

                    LoanData loanData = new LoanData(MainActivity.this);
                    loanData.open();
                    loanData.insertVals(loan);
                    loanData.close();

                } else if (checkingButton.isChecked()){
                    CheckingAccount checkingAccount = new CheckingAccount(
                            accountNumber,
                            currentBalance
                    );

                    CheckingData checkingData = new CheckingData(MainActivity.this);
                    checkingData.open();
                    checkingData.insertVals(checkingAccount);
                    checkingData.close();
                }
            }
        });
    }

    void cancelButtonInnit() {
        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /// Text Fields
                EditText accountNumberField = findViewById(R.id.accountNumberEditText);
                EditText initialBalanceField = findViewById(R.id.initialBalanceEditText);
                EditText currentBalanceField = findViewById(R.id.currentBalanceEditText);
                EditText interestRateField = findViewById(R.id.interestRateEditText);
                EditText paymentAmountField = findViewById(R.id.paymentAmountEditText);

                accountNumberField.setText("");
                initialBalanceField.setText("");
                currentBalanceField.setText("");
                interestRateField.setText("");
                paymentAmountField.setText("");
            }
        });
    }

}