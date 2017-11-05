package com.example.quyo.tipcalculator;

import android.app.ActionBar;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

import static com.example.quyo.tipcalculator.R.string;

public class MainActivity extends AppCompatActivity {
    double totalAmount;
    double totalCharges;
    double tipAmount;
    String tipChoices;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText total = (EditText) findViewById(R.id.txtcaption);
        final Spinner group = (Spinner) findViewById(R.id.choices);
        Button charges = (Button)findViewById(R.id.btn_cal);
        charges.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView) findViewById(R.id.total));

            @Override
            public void onClick(View v) {
                totalAmount = Integer.parseInt(billAmount.getText().toString());
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                tipAmount = (Double.parseDouble(tipChoices) / 100) * billAmount;
                totalCharges = tipAmount + totalAmount;
                tipChoices = group.getSelectedItem().toString();
                result.setText("Total cost for " + tipChoices + "for the bill amount of" + totalAmount + " is " + currency.format(totalCharges));
            }
        });
    }
}
