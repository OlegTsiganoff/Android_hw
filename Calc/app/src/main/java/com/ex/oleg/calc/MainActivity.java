package com.ex.oleg.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.editText);

    }

    public void OnResultClick(View view) {
        String expression = editText.getText().toString();
        if(ValidateBrackets(expression))
        {
            try {
                String result = CalculateWithBrackets(expression);
                editText.setText(result);
            }
            catch (ArithmeticException ex)
            {
                editText.setText("syntax error");
            }
        }
        else
        {
            editText.setText("syntax error");
        }
    }

    String CalculateWithBrackets(String expr, int index)
    {
        int indexFirst;
        int indexSecond;
        do {
            indexFirst = expr.indexOf('(', index);
            if(indexFirst >= 0) {
                String bracket = GetNextBracket(expr, indexFirst + 1);
                if(bracket.equals("("))
                    expr = CalculateWithBrackets(expr, indexFirst + 1);
                if(bracket.equals(")"))
                {
                    indexSecond = expr.indexOf(')', index);
                    expr = ReplaceBracketsByResult(expr, indexFirst, indexSecond);
                }
            }
        } while (indexFirst >= 0);

        return CalculateExpression(expr);
    }

    String CalculateWithBrackets(String expr)
    {
        int indexSecond;
        indexSecond = expr.indexOf(")");
        if(indexSecond >= 0)
        {
            int indexFirst = IndexOfPreviouseBracket(expr, indexSecond);
            expr = ReplaceBracketsByResult(expr, indexFirst, indexSecond);
            expr = CalculateWithBrackets(expr);
        }

        return CalculateExpression(expr);
    }

    int IndexOfPreviouseBracket(String expr, int indexSecond)
    {
        if(indexSecond < 0 || indexSecond >= expr.length())
            return -1;
        for(int i = indexSecond; i >= 0; i--)
        {
            if(expr.charAt(i) == '(')
                return i;
        }
        return -1;
    }

    String ReplaceBracketsByResult(String expr, int indexFirst, int indexSecond)
    {
        String strTmp = expr.substring(indexFirst, indexSecond);
        strTmp = strTmp.replace("(", "");
        strTmp = strTmp.replace(")", "");
        strTmp =  CalculateExpression(strTmp);
        double resNum;
        try
        {
            resNum = Double.valueOf(strTmp);
        }
        catch (Exception ex)
        {
            throw new ArithmeticException();
        }
        String resStr = CutSubstring(expr, resNum, indexFirst, indexSecond);
        return resStr;
    }

    String GetNextBracket(String expr, int indexStart)
    {
        int index1;
        int index2;
        index1 = expr.indexOf('(', indexStart);
        index2 = expr.indexOf(')', indexStart);
        if(index1 >= 0 && index1 < index2)
            return "(";
        else if(index2 >= 0)
            return ")";
        else
            return "";
    }

    String CalculateExpression(String expr)
    {
        if(expr.contains("*") || expr.contains("×"))
        {
            int index = expr.indexOf("*");
            if(index < 0)
                index = expr.indexOf("×");
            return CalculateExpression(ReplaceExprByResult(expr, index));
        }

        if(expr.contains("/") || expr.contains("÷"))
        {
            int index = expr.indexOf("/");
            if(index < 0)
                index = expr.indexOf("÷");
            return CalculateExpression(ReplaceExprByResult(expr, index));
        }

        if(expr.contains("+"))
        {
            return CalculateExpression(ReplaceExprByResult(expr, expr.indexOf("+")));
        }

        if(expr.contains("-"))
        {
            return CalculateExpression(ReplaceExprByResult(expr, expr.indexOf("-")));
        }
        return expr;
    }

    String ReplaceExprByResult(String expr, int indexOfOperator)
    {
        String aStr = FindOperand(expr, indexOfOperator, true);
        String bStr = FindOperand(expr, indexOfOperator, false);
        double a = ParseStringToDouble(aStr);
        double b = ParseStringToDouble(bStr);
        double res = Calculate(a, b, expr.charAt(indexOfOperator));
        int indexStart = FindIndexOfNumber(expr, indexOfOperator, true);
        int indexEnd = FindIndexOfNumber(expr, indexOfOperator, false);
        String resultExpr = CutSubstring(expr, res, indexStart, indexEnd);
        return resultExpr;
    }

    double ParseStringToDouble(String numStr)
    {
        try
        {
            return Double.valueOf(numStr);
        }
        catch (Exception ex)
        {
            throw  new ArithmeticException();
        }
    }

    String CutSubstring(String string, double result, int start, int end)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++)
        {
            if(i < start || i > end)
                sb.append(string.charAt(i));
        }
        sb.insert(start, result);
        return sb.toString();
    }

    double Calculate(double a, double b, char operator)
    {
        switch (operator)
        {
            case '+':
                return MyMath.Plus(a, b);
            case '-':
                return MyMath.Minus(a, b);
            case '*':
            case '×':
                return MyMath.Multi(a, b);
            case '/':
            case '÷':
                return MyMath.Divide(a, b);
        }
        throw new ArithmeticException();
    }

    String FindOperand(String expr, int index, boolean isLeft)
    {
        double result = 0;
        StringBuilder num = new StringBuilder();
        int count = 1;
        while (true)
        {
            int indexTmp = MoveIndex(index, count, isLeft);
            if(indexTmp >= 0 && indexTmp < expr.length())
            {
                Character charTmp = expr.charAt(indexTmp);
                if(Character.isDigit(charTmp) || charTmp == '.')
                    num.append(charTmp);
                else
                    break;
            }
            else
            {
                break;
            }
            count++;
        }
        if(isLeft)
            num.reverse();
        return num.toString();
    }

    int MoveIndex(int index, int count, boolean toLeft)
    {
        if(toLeft)
            return index - count;
        else
            return index + count;
    }

    int FindIndexOfNumber(String expr, int indexOfOperator, boolean isLeft)
    {
        int count = 1;
        while (true)
        {
            int indexTmp = MoveIndex(indexOfOperator, count, isLeft);
            if(indexTmp >= 0 && indexTmp < expr.length())
            {
                Character charTmp = expr.charAt(indexTmp);
                if(Character.isDigit(charTmp) || charTmp == '.')
                    count++;
                else
                    break;
            }
            else
                break;
        }
        if(isLeft)
            return indexOfOperator - count + 1;
        else
            return indexOfOperator + count - 1;
    }

    boolean ValidateBrackets(String expr)
    {
        int counter = 0;
        for(int i = 0; i < expr.length(); i++)
        {
            if(expr.charAt(i) == '(')
                counter++;
            if(expr.charAt(i) == ')')
                counter--;
            if(counter < 0)
                return false;
        }
        return counter == 0;
    }
}
