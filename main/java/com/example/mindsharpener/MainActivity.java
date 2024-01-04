package com.example.mindsharpener;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int currentLevel = 3;
    private int currentOperator;
    private int currentAnswer;
    private int currentScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioButton radioButton1 = findViewById(R.id.radioButton1);
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        RadioButton radioButton3 = findViewById(R.id.radioButton3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);
        EditText editText = findViewById(R.id.editText);
        Button bigButton = findViewById(R.id.bigButton);
        TextView textView7 = findViewById(R.id.textView7);
        TextView textView8 = findViewById(R.id.textView8);

        // Set default text for POINT
        textView8.setText("0");

        textView1.setText("Instructions:");
        textView2.setText("This is a simple mathematic game believed to train your brain. " +
                "Two numbers are given randomly based on your level choice together with the operator. " +
                "You just need to calculate the answer, write your answer, and press the check button. " +
                "Every correct answer will give you 1 point, while a wrong answer will deduct 1 point.");

        textView3.setText("Choose Level:");
        radioButton1.setText("i3");
        radioButton2.setText("i5");
        radioButton3.setText("i7");
        textView4.setText("                         1");
        textView5.setText("+");
        textView6.setText("1");
        textView7.setText("             POINT:");

        bigButton.setText("Check");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton1:
                        currentLevel = 3;
                        break;
                    case R.id.radioButton2:
                        currentLevel = 5;
                        break;
                    case R.id.radioButton3:
                        currentLevel = 7;
                        break;
                }

                // Generate a new question based on the selected level
                generateQuestion();
            }
        });

        bigButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
                generateQuestion();
            }
        });

        generateQuestion();
    }

    private void generateQuestion() {
        Random random = new Random();
        int operand1, operand2;

        switch (currentLevel) {
            case 3:
                operand1 = random.nextInt(10);
                operand2 = random.nextInt(10);
                break;
            case 5:
                operand1 = random.nextInt(90) + 10; // Two digits for i5 (10-99)
                operand2 = random.nextInt(90) + 10;
                break;
            case 7:
                operand1 = random.nextInt(900) + 100; // Three digits for i7 (100-999)
                operand2 = random.nextInt(900) + 100;
                break;
            default:
                operand1 = 0;
                operand2 = 0;
                break;
        }

        currentOperator = random.nextInt(4);

        String operatorSymbol = getOperatorSymbol(currentOperator);

        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);

        textView4.setText(String.valueOf(operand1));
        textView5.setText(operatorSymbol);
        textView6.setText(String.valueOf(operand2));

        currentAnswer = calculateAnswer(operand1, operand2, currentOperator);
    }

    private void checkAnswer() {
        EditText editText = findViewById(R.id.editText);
        String userAnswerString = editText.getText().toString();

        if (!userAnswerString.isEmpty()) {
            int userAnswer = Integer.parseInt(userAnswerString);

            if (userAnswer == currentAnswer) {
                currentScore++;
            } else {
                currentScore--;
            }


            TextView textView8 = findViewById(R.id.textView8);
            textView8.setText(String.valueOf(currentScore));
        }
    }

    private int calculateAnswer(int operand1, int operand2, int operator) {
        switch (operator) {
            case 0:
                return operand1 + operand2;
            case 1:
                return operand1 - operand2;
            case 2:
                return operand1 * operand2;
            case 3:
                return operand1 / operand2;
            default:
                return 0;
        }
    }

    private String getOperatorSymbol(int operator) {
        switch (operator) {
            case 0:
                return "+";
            case 1:
                return "-";
            case 2:
                return "*";
            case 3:
                return "/";
            default:
                return "";
        }
    }
}
