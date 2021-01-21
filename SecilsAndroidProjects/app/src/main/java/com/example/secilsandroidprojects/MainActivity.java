 package com.example.secilsandroidprojects;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Project[] projects = {
                new Project("Getting Started App", "Our very first project, the default 'Hello World' app!", R.drawable.getting_started),
                new Project("Secil Quote", "Make a simple quote app!", R.drawable.quote),
                new Project("BMI Calculator", "A real world BMI calculator!", R.drawable.calculator),
                new Project("Inches Converter", "An app helps to convert inches to meters!", R.drawable.tape),
                new Project("The Hunger Developer", "A menu app that I have learnt the activities, explicit - implicit intents and list views ", R.drawable.hungry_developer)
        };




    }
}