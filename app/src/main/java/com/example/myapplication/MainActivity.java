package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

import org.mariuszgromada.math.mxparser.*;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

    }

    private void updateText(String strToAdd){
        String oldstr = display.getText().toString();
        int cursorpos = display.getSelectionStart();
        String leftstr = oldstr.substring(0,cursorpos);
        String rightstr = oldstr.substring(cursorpos);

        if(getString(R.string.display).equals(display.getText().toString()))
        {
            display.setText(strToAdd);
            cursorpos = cursorpos +1;
        }

        else {
            display.setText(String.format("%s%s%s", leftstr, strToAdd, rightstr));
            display.setSelection(cursorpos + 1);
        }
    }

    public void zeroBTN(View view) {
        updateText("0");
    }

    public void oneBTN(View view) {
        updateText("1");
    }

    public void twoBTN(View view){
        updateText("2");
    }

    public void threeBTN(View view){
        updateText("3");
    }

    public void fourBTN(View view){
        updateText("4");
    }

    public void fiveBTN(View view){
        updateText("5");
    }

    public void sixBTN(View view){
        updateText("6");
    }

    public void sevenBTN(View view){
        updateText("7");
    }

    public void eightBTN(View view){
        updateText("8");
    }

    public void nineBTN(View view){
        updateText("9");
    }

    public void dotBTN(View view){
        updateText(".");
    }

    public void equalBTN(View view){

        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("×" , "*");
        userExp = userExp.replaceAll("÷" , "/");
        userExp = userExp.replaceAll("π" , "pi");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

    public void plusBTN(View view){
        updateText("+");
    }

    public void minusBTN(View view){
        updateText("-");
    }

    public void multiplyBTN(View view){
        updateText("×");
    }

    public void divideBTN(View view){
        updateText("÷");
    }

    public void powerBTN(View view){
        updateText("^");
    }

    public void piBTN(View view){
        updateText("π");
    }

    public void allclearBTN(View view){
        display.setText("");
    }

    public void clearBTN(View view){

        int cursorpos = display.getSelectionStart();
        int length = display.getText().length();

        if(cursorpos !=0 || length !=0)
        {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorpos -1 , cursorpos , "");
            display.setText(selection);
            display.setSelection(cursorpos-1);
        }
    }


}