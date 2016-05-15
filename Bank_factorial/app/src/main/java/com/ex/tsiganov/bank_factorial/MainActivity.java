package com.ex.tsiganov.bank_factorial;

import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    double balance = 700;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textView = (TextView)findViewById(R.id.myTextView);
        textView.setText("Программа Банк. \n Сумма кредита 700, минимальная сумма платежа 100.\n Введите сумму и нажмите кнопку." );
    }

    public void OnBalanceClick(View view) {
        TextView textView = (TextView) findViewById(R.id.resultTextView);
        EditText editText = (EditText) findViewById(R.id.myEditText);

        double payment = 0;
        boolean isParsed;
        isParsed = false;
        try {
            payment = Double.parseDouble(editText.getText().toString());
            isParsed = true;
        } catch (Exception ex) {
            textView.setText("Некорректная сумма!");
        }

        if (!isParsed)
            return;

        textView.setText(Balance(payment));
    }

    public void OnFactorialClick(View view) {
        TextView textView = (TextView) findViewById(R.id.resultTextView2);
        EditText editText = (EditText) findViewById(R.id.myEditText2);

        int num = 0;
        boolean isParsed;
        isParsed = false;
        try {
            num = Integer.parseInt(editText.getText().toString());
            isParsed = true;
        } catch (Exception ex) {
            textView.setText("Некорректное число!");
        }

        if (!isParsed)
            return;

        textView.setText(Long.toString(factorial(num)));
    }

    String Balance(double payment)
    {
        String result = "";
        if(payment < 100 && balance >= 100)
            result = "Минимальная сумма платежа 100!";
        else
        {
            balance -= payment;
            result = "Оплачено: " + payment;
            if(balance >= 0)
                result += "\nОстаток суммы: " + balance;
            else
                result += "\nПереплата составила : " + -balance;
        }
        return result;
    }

    long factorial(long n)
    {
        if(n == 1)
            return 1;
        else
            return n * factorial(n - 1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
