package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // Class variable is also called fields
    private Button calculateButton;
    private EditText editTextAge;
    private TextView resultText;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private EditText editTextFeet;
    private EditText editTextInches;
    private EditText editTextWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews() {
        resultText = findViewById(R.id.text_view_result);

        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);

        editTextAge = findViewById(R.id.edit_text_age);
        editTextFeet = findViewById(R.id.edit_text_feet);
        editTextInches = findViewById(R.id.edit_text_inches);
        editTextWeight = findViewById(R.id.edit_text_weight);

        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        //Responding a button click
        //Button listener = Smo clicks on a button, smb listens?
        //Every time click button is selected, following block of code is executed
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmiResult = calculateBmi();

                String ageText = editTextAge.getText().toString();
                int age = Integer.parseInt(ageText);

                if (age >= 18) {
                    displayResult(bmiResult);
                } else {
                    displayGuidance(bmiResult);
                }
            }
        });
    }

    private double calculateBmi() {
        String feetText = editTextFeet.getText().toString();
        String inchesText = editTextInches.getText().toString();
        String weightText = editTextWeight.getText().toString();

        // Converting the 'Strings' to 'Int'
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        // Height in meters is the inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;

        // BMI formula = weight in kg divided by weight in meters squared
        double bmi = weight / (heightInMeters * heightInMeters);
        return bmi;
    }

    // We must convert the decimal/double into a String for our Text View
//        String bmiTextResult =  String.valueOf(bmi);
    private void displayResult(double bmi) {

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;

        if (bmi < 18.5) {
            // Display underweight
            fullResultString = bmiTextResult + " - You are underweight ";
        } else if (bmi > 25) {
            // Display overweight
            fullResultString = bmiTextResult + " - You are overweight ";
        } else {
            // Display healthy
            fullResultString = bmiTextResult + " - You are a healthy weight ";
        }
        resultText.setText(fullResultString);
    }

    private void displayGuidance(double bmi) {

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (radioButtonMale.isChecked()) {
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range for boys ";
        } else if (radioButtonFemale.isChecked()) {
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range for female ";
        } else {
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range ";
        }
        resultText.setText(fullResultString);
    }
}