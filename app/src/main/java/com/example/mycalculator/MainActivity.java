package com.example.mycalculator;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn_plus, btn_minus, btn_mult, btn_division, btn_dot, btn_clear, btn_equal;
    TextView text_display;
    private boolean clearText = false;
    private String lastResult = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btn_plus = findViewById(R.id.btn_plus);
        btn_minus = findViewById(R.id.btn_minus);
        btn_mult = findViewById(R.id.btn_mult);
        btn_division = findViewById(R.id.btn_division);
        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        btn_clear = findViewById(R.id.btn_clear);
        text_display = (TextView) findViewById(R.id.textview_input_display);

        setClickListeners();
    }

    private void setClickListeners() {
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn_dot.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_mult.setOnClickListener(this);
        btn_division.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn0)
            addNumber("0");
        if (v.getId() == R.id.btn1)
            addNumber("1");
        if (v.getId() == R.id.btn2)
            addNumber("2");
        if (v.getId() == R.id.btn3)
            addNumber("3");
        if (v.getId() == R.id.btn4)
            addNumber("4");

        if (v.getId() == R.id.btn5)
            addNumber("5");

        if (v.getId() == R.id.btn6)
            addNumber("6");

        if (v.getId() == R.id.btn7)
            addNumber("7");

        if (v.getId() == R.id.btn8)
            addNumber("8");

        if (v.getId() == R.id.btn9)
            addNumber("9");

        if (v.getId() == R.id.btn_dot)
            addNumber(".");



        if (v.getId() == R.id.btn_minus)
            addNumber("-");


        if (v.getId() == R.id.btn_mult)
            addNumber("*");


        if (v.getId() == R.id.btn_division)
            addNumber("/");


        if (v.getId() == R.id.btn_plus)
            addNumber("+");


        if (v.getId() == R.id.btn_equal) {
            clearText = true;
            String expr = text_display.getText().toString();
            String result = MathEval.eval(expr);
            text_display.setText(result);

            if ("Error".equals(result)) {
                lastResult = null;
            } else {
                lastResult = result;
            }

        }
        if (v.getId() == R.id.btn_clear) {
            lastResult = null;
            clear_display();
        }
    }

    private void addNumber(String number) {
        if (clearText) {
            clear_display();
            clearText = false;
        }
        if (lastResult != null && "+-*/".contains(number)) {
            text_display.setText(lastResult);
            lastResult = null;
        } else {
            lastResult = null;
        }
        text_display.setText(text_display.getText() + number);
    }

    private void clear_display() {
        text_display.setText("");
    }
}
