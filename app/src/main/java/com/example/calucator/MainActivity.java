package com.example.calucator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView textHistory;
    TextView textResult;

    Button bts0;
    Button bts1;
    Button bts2;
    Button bts3;
    Button bts4;
    Button bts5;
    Button bts6;
     Button bts7;
     Button bts8;
     Button bts9;

     Button Ac;
     Button Del;
     Button addition;
     Button substraction;
     Button multiplication;
     Button Division;


     Button equals;


     Button Dot;


     private String number=null;

     double firstNumber=0;
     double secondNumber=0;
     String status=null;
     boolean operator=false;

     boolean dot=true;
     boolean butAccontrol=true;
     boolean equalcontrol=false;
     String history_view,cureent_result;


     DecimalFormat myformat =new DecimalFormat("######.######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textHistory = findViewById(R.id.textViewHistory);
        textResult = findViewById(R.id.textViewResult);

        bts0 = findViewById(R.id.bts0);
        bts1 = findViewById(R.id.bts1);

        bts2 = findViewById(R.id.bts2);
        bts3 = findViewById(R.id.bts3);
        bts4 = findViewById(R.id.bts4);
        bts5 = findViewById(R.id.bts5);
        bts6 = findViewById(R.id.bts6);
        bts7 = findViewById(R.id.bts7);
        bts8 = findViewById(R.id.bts8);
        bts9 = findViewById(R.id.bts9);

        equals = findViewById(R.id.Equals);
        addition = findViewById(R.id.Addition);
        substraction = findViewById(R.id.Minus);
        multiplication = findViewById(R.id.mulitiplication);
        Division = findViewById(R.id.Divide);


        Dot = findViewById(R.id.Dot);
        Del = findViewById(R.id.Del);
        Ac=findViewById(R.id.ac);


        bts0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNumber("0");
            }
        });



        bts1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNumber("1");
            }
        });
        bts2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNumber("2");
            }
        });
        bts3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showNumber("3");
            }
        });
        bts4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNumber("4");
            }
        });
        bts5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showNumber("5");
            }
        });
        bts6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNumber("6");
            }
        });
        bts7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showNumber("7");
            }
        });
        bts8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showNumber("8");
            }
        });
        bts9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showNumber("9");
            }
        });

        Ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=null;
                status=null;
                textResult.setText("0");
                textHistory.setText("");
                firstNumber=0;
                secondNumber=0;
                dot=true;
                butAccontrol=true;

            }
        });
        Del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(butAccontrol)
                {
                    textResult.setText("0");
                }
                else {
                    number=number.substring(0,number.length()-1);
                    if(number.length()==0)
                    {
                        Del.setClickable(false);
                    } else if (number.contains(".")) {
                        dot=false;

                    }
                    else {
                        dot=true;
                    }
                    textResult.setText(""+number);
                }

            }
        });
        Dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dot){
                    if(number==null)
                    {
                        number="0.";

                    }
                    else
                    {
                        number=number+".";
                    }
                }

                textResult.setText(""+number);
                dot=false;

            }
        });
        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history_view= textHistory.getText().toString();
                cureent_result=textResult.getText().toString();
                textHistory.setText(history_view+cureent_result+"+");

                if(operator)
                {
                   if( status=="mulipication")
                   {
                       mul();
                   }
                   else if(status=="division") {
                       divide();
                   }
                   else if( status=="subtraction") {
                       sub();
                   }
                    else
                    {
                        add();
                   }
                }
                operator=false;
                status="addition";
                number=null;


            }
        });
        substraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history_view= textHistory.getText().toString();
                cureent_result=textResult.getText().toString();
                textHistory.setText(history_view+cureent_result+"-");
                if(operator)
                {
                    if( status=="mulipication")
                    {
                        mul();
                    }
                    else if( status=="addition")
                    {
                        add();
                    }
                    else if(status=="division")
                    {
                        divide();
                    }
                    else {
                        sub();
                    }

                }
                operator=false;
                status="subtraction";
                number=null;

            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history_view= textHistory.getText().toString();
                cureent_result=textResult.getText().toString();
                textHistory.setText(history_view+cureent_result+"*");
                if(operator)
                {
                    if( status=="addition")
                    {
                        add();
                    }
                    else if( status=="subtraction")
                    {
                        sub();
                    }
                    else if(status=="division")
                    {
                        divide();
                    }
                    else {
                        mul();
                    }

                }
                operator=false;
                status="mulipication";
                number=null;

            }
        });
        Division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                history_view= textHistory.getText().toString();
                cureent_result=textResult.getText().toString();
                textHistory.setText(history_view+cureent_result+"/");
                if(operator){
                    if(status=="mulipication")
                    {
                        mul();
                    }
                    else if(status=="addition")
                    {
                        add();
                    }
                    else if(status=="subtraction")
                    {
                        sub();
                    }
                    else {
                        divide();
                    }
                }
                operator=false;
                status="division";
                number=null;

            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (operator) {
                        if (status == "mulipication") {
                            mul();
                        } else if (status == "addition") {
                            add();
                        } else if (status == "subtraction") {
                            sub();
                        } else if (status == "division") {
                            divide();
                        }
                        else {
                            firstNumber=Double.parseDouble(textResult.getText().toString());
                        }
                        operator = false;
                        equalcontrol=true;
                    }


            }
        });


    }
    public void showNumber(String View)
    {
        if(number==null)
        {
         number=View;

        } else if (equalcontrol) {

            firstNumber=0;
            secondNumber=0;
            number=View;

        } else
        {
            number=number+View;
        }
        textResult.setText(""+number);
        operator=true;
        butAccontrol=false;
        Del.setClickable(true);
        equalcontrol=false;
    }

    public void add()
    {
        secondNumber=Double.parseDouble(textResult.getText().toString());
        firstNumber=firstNumber+secondNumber;

        textResult.setText(myformat.format(firstNumber));
        dot=true;
    }


    public void sub()
    {
        if(firstNumber==0)
        {
            firstNumber=Double.parseDouble(textResult.getText().toString());

        }
        else
        {
            secondNumber=Double.parseDouble(textResult.getText().toString());
            firstNumber=firstNumber-secondNumber;
        }
        textResult.setText(myformat.format(firstNumber));
        dot=true;
    }

    public void mul()
    {
        if(firstNumber==0){
            firstNumber=1;
            secondNumber=Double.parseDouble(textResult.getText().toString());
            firstNumber=firstNumber*secondNumber;
        }
        else
        {
            secondNumber=Double.parseDouble(textResult.getText().toString());
            firstNumber=firstNumber*secondNumber;
        }

        textResult.setText(myformat.format(firstNumber));
        dot=true;
    }

    public void divide()
    {
        if(firstNumber==0){
            secondNumber=Double.parseDouble(textResult.getText().toString());
            firstNumber=firstNumber/1;
        }
        else
        {
            secondNumber=Double.parseDouble(textResult.getText().toString());
            firstNumber=firstNumber/secondNumber;
        }
        textResult.setText(myformat.format(firstNumber));
        dot=true;
    }



}