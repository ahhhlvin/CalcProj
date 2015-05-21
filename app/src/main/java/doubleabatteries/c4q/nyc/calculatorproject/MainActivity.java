package doubleabatteries.c4q.nyc.calculatorproject;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import java.util.ArrayList;


// TODO: y√x // X! // PERCENTAGE // DECIMAL // INV code!

// TODO: implement HORIZONTAL scrollview in TextView!
// TODO: change color + shape of buttons ['=' and 'rad' and 'deg']!
// TODO: change app icon for calculator!


// TODO: 1) PERCENTAGE && 2) DECIMAL

public class MainActivity extends ActionBarActivity {

    Expression expression;
//    boolean isRadian;

    boolean enterPressed = false;
    String ans;
    TextView textview;
    int parenOpenCount = 0;

    Button buttonRadian;
    Button buttonDegree;
    Button buttonSin;
    Button buttonLn;
    Button buttonCos;
    Button buttonLog;
    Button buttonTan;
    Button buttonSquareRoot;
    Button buttonAns;
    Button buttonExponent;


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
                        textview.append(" ) ");
                        parenOpenCount--;
                    }else{
                        enterClear(enterPressed);
                        textview.append(" ( ");
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
                    textview.append(" + ");
                }

                enterClear(enterPressed);

            }
        });
        Button buttonSubtract = (Button) findViewById(R.id.subtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                } else if (!isOperator(textview.getText().toString())){
                    textview.append(((Button) view).getText().toString());
                }

                enterClear(enterPressed);

            }
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
                enterClear(enterPressed);
                if (text.equals("")) {
                    // do nothing
                } else {
                    char lastChar = text.charAt(text.length() - 1);
                    if(lastChar == '('){
                        parenOpenCount--;
                    }else if(lastChar == ')'){
                        parenOpenCount++;
                    }
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

                    textview.append(((Button) view).getText().toString());
                }

                enterClear(enterPressed);
            }
        });
        Button buttonDivide = (Button) findViewById(R.id.divide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                } else if (!isOperator(textview.getText().toString())){
                    textview.append("/");
                }

                enterClear(enterPressed);

            }
        });


// ENTER BUTTON HERE !!

        Button buttonEnter = (Button) findViewById(R.id.enter);
        buttonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textview.getText().equals("")) {
                } else if (parenOpenCount > 0 ) {
                    textview.setText("SYNTAX ERROR");
                } else {
                    try {
                        String parsedString = parseEquation(textview.getText().toString());
                        expression = new Expression(parsedString);
                        BigDecimal answer = expression.eval();
                        textview.setText(answer.toPlainString());
                        ans = answer.toPlainString();
                        enterPressed = true;
                    } catch (RuntimeException e){
                        textview.setText("ERROR");
                    }
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


        buttonRadian = (Button) findViewById(R.id.Radian);
        if (buttonRadian != null) {
            buttonRadian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //                    isRadian = true;
                    buttonDegree.setEnabled(true);
                    buttonRadian.setEnabled(false);
                    enterClear(enterPressed);
                }
            });
        }

        buttonDegree = (Button) findViewById(R.id.Degree);
        if (buttonDegree != null) {
            buttonDegree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    isRadian = false;
                    buttonDegree.setEnabled(false);
                    buttonRadian.setEnabled(true);
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
                    String text = textview.getText().toString();
                    if(text.equals("")){

                    }else if(!isOperator(text)){
                        textview.append("!");
                    }
                }
            });
        }

        Button buttonInverse = (Button) findViewById(R.id.inverse);
        if (buttonInverse != null) {
            buttonInverse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    buttonSin.setText("Sin^-1");
                    buttonLn.setText("e^");
                    buttonCos.setText("Cos^-1");
                    buttonLog.setText("10^x");
                    buttonTan.setText("Tan^-1");
                    buttonSquareRoot.setText("x^2");
                    buttonAns.setText("Rnd");
                    buttonExponent.setText("y√x");
                }
            });
        }

        buttonSin = (Button) findViewById(R.id.sin);
        if (buttonSin != null) {
            buttonSin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    if (buttonSin.getText().toString().equalsIgnoreCase("sin")) {
                        if (isOperator(textview.getText().toString())) {
                            parenOpenCount++;
                            textview.append("sin(");
                        }
                    } else if (buttonSin.getText().toString().equalsIgnoreCase("sin^-1")) {
                        parenOpenCount++;
                        textview.append("asin(");
                    }
                }
            });
        }

        buttonLn = (Button) findViewById(R.id.naturalLog);
        if (buttonLn != null) {
            buttonLn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);

                    if (buttonLn.getText().toString().equalsIgnoreCase("ln")) {
                        if (isOperator(textview.getText().toString())) {
                            parenOpenCount++;
                            textview.append("log(");
                        }
                    } else if (buttonLn.getText().toString().equalsIgnoreCase("e^")) {
                        if (isOperator(textview.getText().toString())) {
                            parenOpenCount++;
                            textview.append("e^(");
                        }
                    }

                }
            });
        }

        Button buttonPi = (Button) findViewById(R.id.pi);
        if (buttonPi != null) {
            buttonPi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String text = textview.getText().toString();
                    enterClear(enterPressed);
                    if (isOperator(textview.getText().toString()) || textview.getText().toString().charAt(text.length()-1) == '(') {
                        textview.append("PI");
                    }
                }
            });
        }

        buttonCos = (Button) findViewById(R.id.cos);
        if (buttonCos != null) {
            buttonCos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);

                    if (buttonCos.getText().toString().equalsIgnoreCase("cos")) {
                        if (isOperator(textview.getText().toString())) {
                            parenOpenCount++;
                            textview.append("cos(");
                        }
                    } else if (buttonCos.getText().toString().equalsIgnoreCase("cos^-1")) {
                        parenOpenCount++;
                        textview.append("acos(");
                    }

                }
            });
        }

        buttonLog = (Button) findViewById(R.id.log);
        if (buttonLog != null) {
            buttonLog.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);

                    if (buttonLog.getText().toString().equalsIgnoreCase("log")) {
                        if (isOperator(textview.getText().toString())) {
                            parenOpenCount++;
                            textview.append("log10(");
                        }
                    } else if (buttonLog.getText().toString().equalsIgnoreCase("10^")) {
                        if (isOperator(textview.getText().toString())) {
                            parenOpenCount++;
                            textview.append("10^(");
                        }
                    }

                }
            });
        }

        Button buttonE = (Button) findViewById(R.id.e);
        if (buttonE != null) {
            buttonE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    if (isOperator(textview.getText().toString())) {
                        textview.append("e");
                    }

                }
            });
        }

        buttonTan = (Button) findViewById(R.id.tan);
        if (buttonTan != null) {
            buttonTan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);

                    if (buttonTan.getText().toString().equalsIgnoreCase("tan")) {
                        if (isOperator(textview.getText().toString())) {
                            parenOpenCount++;
                            textview.append("tan(");
                        }
                    } else if (buttonTan.getText().toString().equalsIgnoreCase("tan^-1")) {
                        parenOpenCount++;
                        textview.append("atan(");
                    }

                }
            });
        }

        buttonSquareRoot = (Button) findViewById(R.id.squareRoot);
        if (buttonSquareRoot != null) {
            buttonSquareRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);

                    if (buttonSquareRoot.getText().toString().equalsIgnoreCase("√")) {
                        if (isOperator(textview.getText().toString())) {
                            parenOpenCount++;
                            textview.append("sqrt(");
                        }
                    } else if (buttonSquareRoot.getText().toString().equalsIgnoreCase("x^2")) {
                        // TODO: will there be an issue with parentheses and parsing order??
                        if (!isOperator(textview.getText().toString()) || !textview.getText().toString().equals("")) {
                            textview.append("^2");
                        }
                    }
                }
            });
        }

        buttonAns = (Button) findViewById(R.id.Answer);
        if (buttonAns != null) {
            buttonAns.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);

                    if (buttonAns.getText().toString().equalsIgnoreCase("Ans")) {
                        if (isOperator(textview.getText().toString())) {
                            textview.append(ans.toString());
                        }
                    } else if (buttonAns.getText().toString().equalsIgnoreCase("Rnd")) {
                        double num = Math.random();
                        if (isOperator(textview.getText().toString())) {
                            textview.append(String.valueOf(num));
                        }
                    }

                }
            });
        }

        Button buttonExp = (Button) findViewById(R.id.exponent);
        if (buttonExp != null) {
            buttonExp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    enterClear(enterPressed);
                    if (isOperator(textview.getText().toString())) {
                        parenOpenCount++;
                        textview.append("10^(");
                    }

                }
            });
        }

        buttonExponent = (Button) findViewById(R.id.exponential);
        if (buttonExponent != null) {
            buttonExponent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (textview.getText().equals("")) {
                    } else if (!isOperator(textview.getText().toString())){
                        enterClear(enterPressed);

                        if (buttonExponent.getText().toString().equalsIgnoreCase("x^y")) {

                            if (!isOperator(textview.getText().toString())) {

                                parenOpenCount++;
                                textview.append("^(");
                            }
                        } else if (buttonExponent.getText().toString().equalsIgnoreCase("y√x")) {

                        }

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

    // TODO: FIX THIS !!!!!
    public void Parse(boolean bool) {
        if (bool == false) {
//            expression = new Expression("DEG("+textview.getText().toString()+")");
//            BigDecimal answer = expression.eval();
//            textview.setText(answer.toPlainString());
//            ans = answer.toPlainString();
//            enterPressed = true;
        } else {
//            expression = new Expression("RAD("+textview.getText().toString()+")");
//            BigDecimal answer = expression.eval();
//            textview.setText(answer.toPlainString());
//            ans = answer.toPlainString();
//            enterPressed = true;
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

    public boolean isOperator(char chara){
        return isOperator(Character.toString(chara));
    }

    public boolean isNumber(char chara){
        int aValue = (int) chara;
        return aValue >= 48 && aValue <= 57;
    }

    public String parseEquation(String equation){

        ArrayList<String> equationList = new ArrayList<String>();
        String segment = "";

        for(int i = 0; i < equation.length(); i++){
            char currentChar = equation.charAt(i);
            if(isOperator(currentChar)){
                equationList.add(segment);
                segment = "";
                equationList.add(Character.toString(currentChar));
            }else{
                segment += currentChar;
            }
        }
        equationList.add(segment);

        equation = "";
        for(String eqSegment : equationList){
            eqSegment = parseEqSegment(eqSegment);
            equation += eqSegment;
        }
        return equation;
    }

    public String parseEqSegment(String segment){

        for(int i = 0; i < segment.length(); i++){
            if(segment.charAt(i) == '!'){
                int factIndex = i;
                int numStart = 0;

                for(int j = factIndex - 1; j >= 0; j--){

                    if(!isNumber(segment.charAt(j))){
                        numStart = j+1;
                        break;
                    }
                }

                String numString = segment.substring(numStart,factIndex);
                int num = Integer.parseInt(numString);

                String factString = "(1";

                for(int j = 2; j <= num; j++){
                    factString += "*" + j;
                }

                factString += ")";

                String newSegment = "";

                for(int j = 0; j < numStart; j++){
                    newSegment += segment.charAt(j);
                }
                newSegment += factString;
                for(int j = factIndex+1; j < segment.length(); j++){
                    newSegment += segment.charAt(j);
                }

                return newSegment;

            }
        }

        return segment;
    }

}

