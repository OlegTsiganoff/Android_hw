package com.ex.oleg.rectangle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OnClick(View view) {
        EditText textSide1 = (EditText)findViewById(R.id.side1EditText);
        EditText textSide2 = (EditText)findViewById(R.id.side2EditText);
        TextView resultText = (TextView)findViewById(R.id.resultTextView);
        Rectangle rect;
        try {
            rect = new Rectangle(Double.valueOf(textSide1.getText().toString()), Double.valueOf(textSide2.getText().toString()));
        }
        catch (Exception ex)
        {
            resultText.setText("Введены неправильные значения!");
            return;
        }

        String result = "Периметр прямоугольника = " + rect.getPerimeter() + "\n" +
                "Площадь прямоугольника = " + rect.getArea();
        resultText.setText(result);
    }
}
