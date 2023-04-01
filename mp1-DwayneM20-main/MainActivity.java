package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText amount;
    TextView percent;
    SeekBar sbPercent;
    TextView tip;
    TextView total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = findViewById(R.id.et_amount);
        percent = findViewById(R.id.tv_percent);
        sbPercent= findViewById(R.id.sb_percent);
        tip = findViewById(R.id.tv_tip);
        total = findViewById(R.id.tv_total);

        sbPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int percent = i;
                MainActivity.this.percent.setText(String.valueOf(percent)+"%");
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        amount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculate();
            }
        });
    }

    private void calculate(){
        if(amount.length()==0){

            amount.setError("Enter Amount");
        }else{
            double amount = Double.parseDouble(this.amount.getText().toString());
            int percent = sbPercent.getProgress();
            double tip = amount*percent/100.0;
            double total = amount + tip;
            this.tip.setText(String.valueOf(tip));
            this.total.setText(String.valueOf (total));
        }
    }
}
