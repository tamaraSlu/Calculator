package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView rs;
    Double firstNumber;
    Double secondNumber;
    char operation;
    double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rs=findViewById(R.id.textViewResult);
    }
    public void operationInsertion(View v){
        if(v instanceof Button){
            Button b= (Button) v;
            String str=rs.getText().toString();
            if(firstNumber==null)
            {
                firstNumber=Double.parseDouble(str);
                operation=b.getText().toString().charAt(0);
            }
            else{
                secondNumber=Double.parseDouble(str);
                firstNumber=mergeNumbers(firstNumber,secondNumber,operation);
                operation=b.getText().toString().charAt(0);
                secondNumber=null;
            }
            if(firstNumber==null)
            {
                rs.setText("Invalid Operation!");
            }
            else{
                rs.setText("");
                rs.setText(String.valueOf(operation));
            }

        }
    }

    public void numberInsertion(View v){
        if(v instanceof Button){
            Button b= (Button) v;
            String currentText=rs.getText().toString();
            String str=b.getText().toString();
            if(firstNumber!=null&&isOpertion(currentText.charAt(0)))
            {
                rs.setText("");
            }
            rs.append(str);
        }
    }

    private boolean isOpertion(char c){
        return (c=='+'||c=='-'||c=='/'||c=='X');
    }
    private Double mergeNumbers(Double num1,Double num2,char operation){
        if(num1==null && num2!=null)
        {
            return num2;
        }
        switch (operation)
        {
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case 'X':
                return num1*num2;
            case '/':
                if(num2==0.0) {
                    return null;
                }
                return num1/num2;
        }
        return null;
    }
    public void calculate(View v){
        if(secondNumber==null) {
            String str = rs.getText().toString();
            secondNumber = Double.parseDouble(str);
            firstNumber = mergeNumbers(firstNumber, secondNumber, operation);

        }
        if(firstNumber==null)
        {
            rs.setText("Invalid Operation!");
        }
        else{
            secondNumber=null;
            rs.setText(String.valueOf(firstNumber));
            firstNumber=null;
        }



    }

    public void clear(View v){
        if(v instanceof Button){
            rs.setText("");
            firstNumber=null;
            secondNumber=null;
        }
    }
}