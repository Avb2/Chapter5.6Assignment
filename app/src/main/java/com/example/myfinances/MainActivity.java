package com.example.myfinances;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initState();
        radioGroupOnChange();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void initState(){
        RadioButton cdButton = findViewById(R.id.cdRadio);
        EditText paymentAmountField = findViewById(R.id.paymentAmountEditText);
        cdButton.setChecked(true);
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


}