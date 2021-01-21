package com.example.convertinchestometers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity<convertToMeter> extends AppCompatActivity {

    private ImageView image;
    private EditText editTextInches;
    private Button convertButton;
    private TextView resultTextMeter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inchesText = editTextInches.getText().toString();
                if (inchesText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please input a value", Toast.LENGTH_SHORT).show();
                } else {
                    double result = convertToMeters(inchesText);
                    displayResult(result);
                }
            }
        });
    }

    public void findViews() {
        image = findViewById(R.id.img);
        editTextInches = findViewById(R.id.edit_text_inches);
        convertButton = findViewById(R.id.button_convert);
        resultTextMeter = findViewById(R.id.text_view_result);
    }

    public double convertToMeters(String inchesText) {
        // Convert String to int
        double inches = Double.parseDouble(inchesText);
        return inches * 0.0254;
    }


    private void displayResult(double result) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String resultString = myDecimalFormatter.format(result);
        resultTextMeter.setText(resultString);
    }

}