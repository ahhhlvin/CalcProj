package doubleabatteries.c4q.nyc.calculatorproject;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;


// TODO: implement HORIZONTAL scrollview in textview!
// TODO: change color + shape of buttons!
// TODO: remove action bar title (in landscape view or both)!
// TODO: change icon for calculator!


public class MainActivity extends ActionBarActivity {

    boolean enterPressed = false;
    String ans;
    TextView textview;
    int parenOpenCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = (TextView) findViewById(R.id.textView);
        textview.setTextSize(30);

        if(savedInstanceState != null){
            textview.setText(savedInstanceState.getString("equation"));
        }



        Button button7 = (Button) findViewById(R.id.seven);
        button7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("7");
            }
        });
        Button button8 = (Button) findViewById(R.id.eight);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("8");
            }
        });
        Button button9 = (Button) findViewById(R.id.nine);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("9");
            }
        });
        Button button4 = (Button) findViewById(R.id.four);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("4");
            }
        });
        Button button5 = (Button) findViewById(R.id.five);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = view.getId();
                enterClear(enterPressed);
                textview.append("5");
            }
        });
        Button button6 = (Button) findViewById(R.id.six);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("6");
            }
        });
        Button button1 = (Button) findViewById(R.id.one);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("1");
            }
        });
        Button button2 = (Button) findViewById(R.id.two);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("2");
            }
        });
        Button button3 = (Button) findViewById(R.id.three);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("3");
            }
        });

        // TODO!!
        Button buttonParen = (Button) findViewById(R.id.parentheses);
        buttonParen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean shouldClose;

                if(textview.getText().toString().equals("")){
                    shouldClose = false;
                }else{
                    String equation = textview.getText().toString();
                    char lastChar = equation.charAt(equation.length() - 1);

                    if(isOperator(Character.toString(lastChar))){
                        shouldClose = false;
                    }else if(lastChar == '('){
                        shouldClose = false;
                    }else if(lastChar == ')' && parenOpenCount == 0){
                        shouldClose = false;
                        textview.append("*");
                    }else if(lastChar == ')'){
                        shouldClose = true;
                    }else if(parenOpenCount == 0){
                        shouldClose = false;
                        textview.append("*");
                    }else{
                        shouldClose = true;
                    }

                }
                    if(shouldClose){
                        enterClear(enterPressed);
                        textview.append(")");
                        parenOpenCount--;
                    }else{
                        enterClear(enterPressed);
                        textview.append("(");
                        parenOpenCount++;
                    }




            }
        });
        Button button0 = (Button) findViewById(R.id.zero);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append("0");
            }
        });

        // TODO !!
        Button buttonDecimal = (Button) findViewById(R.id.decimal);
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enterClear(enterPressed);
                textview.append(".");
            }
        });
        Button buttonClear = (Button) findViewById(R.id.clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText("");
            }
        });
        Button buttonAdd = (Button) findViewById(R.id.add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                } else if (!isOperator(textview.getText().toString())){
                    enterClear(enterPressed);
                    textview.append(((Button) view).getText().toString());
                }
            }
        });
        Button buttonSubtract = (Button) findViewById(R.id.subtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                } else if (!isOperator(textview.getText().toString())){
                    enterClear(enterPressed);
                    textview.append(((Button) view).getText().toString());
                }            }
        });
        Button buttonPercentage = (Button) findViewById(R.id.percentage);
        buttonPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                }
            }
        });
        Button buttonBackspace = (Button) findViewById(R.id.backspace);
        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text =  textview.getText().toString();
                if (text.equals("")) {
                    // do nothing
                } else {
                    char lastChar = text.charAt(text.length() - 1);
                    if(lastChar == '('){
                        parenOpenCount--;
                    }else if(lastChar == ')'){
                        parenOpenCount++;
                    }
                    enterClear(enterPressed);
                    textview.setText(textview.getText().toString().substring(0, textview.getText().toString().length() - 1));
                }
            }
        });
        Button buttonMultiply = (Button) findViewById(R.id.multiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                } else if (!isOperator(textview.getText().toString())){
                    enterClear(enterPressed);
                    textview.append(((Button) view).getText().toString());
                }            }
        });
        Button buttonDivide = (Button) findViewById(R.id.divide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                } else if (!isOperator(textview.getText().toString())){
                    enterClear(enterPressed);
                    textview.append("/");
                }
            }
        });


// ENTER BUTTON HERE !!

        Button buttonEnter = (Button) findViewById(R.id.enter);
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                } else if (parenOpenCount > 0 ) {
                    textview.setText("SYNTAX ERROR!");
                } else {
                    Expression expression = new Expression(textview.getText().toString());
                    BigDecimal answer = expression.eval();
                    textview.setText(answer.toPlainString());
                    ans = answer.toPlainString();
                    enterPressed = true;

                }
            }
        });


        //
        //
        //
        //
        // LANDSCAPE SCIENTIFIC BUTTON CODE
        //
        //
        //
        //
        //


        Button buttonRadian = (Button) findViewById(R.id.Radian);
        if (buttonRadian != null) {
            buttonRadian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                }
            });
        }

        Button buttonDegree = (Button) findViewById(R.id.Degree);
        if (buttonDegree != null) {
            buttonDegree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                }
            });
        }

        Button buttonFactorial = (Button) findViewById(R.id.factorial);
        if (buttonFactorial != null) {
            buttonFactorial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                }
            });
        }

        Button buttonInverse = (Button) findViewById(R.id.inverse);
        if (buttonInverse != null) {
            buttonInverse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                }
            });
        }

        Button buttonSin = (Button) findViewById(R.id.sin);
        if (buttonSin != null) {
            buttonSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    parenOpenCount++;
                    textview.append("sin(");

                }
            });
        }

        Button buttonLn = (Button) findViewById(R.id.naturalLog);
        if (buttonLn != null) {
            buttonLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    parenOpenCount++;
                    textview.append("ln(");

                }
            });
        }

        Button buttonPi = (Button) findViewById(R.id.pi);
        if (buttonPi != null) {
            buttonPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    textview.append("PI");

                }
            });
        }

        Button buttonCos = (Button) findViewById(R.id.cos);
        if (buttonCos != null) {
            buttonCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    parenOpenCount++;
                    textview.append("cos(");

                }
            });
        }

        Button buttonLog = (Button) findViewById(R.id.log);
        if (buttonLog != null) {
            buttonLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    parenOpenCount++;
                    textview.append("log(");

                }
            });
        }

        Button buttonE = (Button) findViewById(R.id.e);
        if (buttonE != null) {
            buttonE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    textview.append("e");

                }
            });
        }

        Button buttonTan = (Button) findViewById(R.id.tan);
        if (buttonTan != null) {
            buttonTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    parenOpenCount++;
                    textview.append("tan(");

                }
            });
        }

        Button buttonSquareRoot = (Button) findViewById(R.id.squareRoot);
        if (buttonSquareRoot != null) {
            buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    parenOpenCount++;
                    textview.append("sqrt(");

                }
            });
        }

        Button buttonAns = (Button) findViewById(R.id.Answer);
        if (buttonAns != null) {
            buttonAns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    textview.append(ans.toString());

                }
            });
        }

        Button buttonExp = (Button) findViewById(R.id.exponent);
        if (buttonExp != null) {
            buttonExp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    parenOpenCount++;
                    textview.append("10^(");

                }
            });
        }

        Button buttonExponent = (Button) findViewById(R.id.exponential);
        if (buttonExponent != null) {
            buttonExponent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (textview.getText().equals("")) {
                    } else if (!isOperator(textview.getText().toString())){
                        enterClear(enterPressed);
                        parenOpenCount++;
                        textview.append("^(");
                    }

                }
            });
        }








    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("equation", textview.getText().toString());

        super.onSaveInstanceState(outState);
    }


    public void enterClear(boolean bool) {
        if (bool == true) {
            textview.setText("");
            enterPressed = false;

        }
    }


    public boolean isOperator(String input) {

        if (textview.getText().toString().equals("")) {
            return true;
        }

        char lastC = input.charAt(input.length()-1);
        char[] operators = {'+', '-', '*', '÷'};



        for(char operator : operators){
            if (lastC == operator) {
                return true;
            }
        }

        return false;

    }

}

