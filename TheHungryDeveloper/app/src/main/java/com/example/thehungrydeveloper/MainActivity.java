package com.example.thehungrydeveloper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    CardView startersCard;
    CardView mainsCard;
    CardView dessertCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startersCard = findViewById(R.id.card_view_starters);
        mainsCard = findViewById(R.id.card_view_mains);
        dessertCard = findViewById(R.id.card_view_desserts);

        startersCard.setOnClickListener(v -> {
            Intent startersActivityIntent = new Intent(MainActivity.this, StartersActivity.class);
            startActivity(startersActivityIntent);
        });

        mainsCard.setOnClickListener(v -> {
            Intent MainCoursesActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
            startActivity(MainCoursesActivityIntent);
        });

        TextView emailTextView = findViewById(R.id.text_view_email_address);
        emailTextView.setOnClickListener(v -> {
            Intent LaunchEmailAppIntent = new Intent(Intent.ACTION_SENDTO);
            LaunchEmailAppIntent.setData(Uri.parse("mailto:thehungrydev@gmail.com")); // only email apps should handle this
            startActivity(LaunchEmailAppIntent);
        });

        dessertCard.setOnClickListener( v -> {
            Intent dessertActivityIntent = new Intent(MainActivity.this, DessertActivity.class);
            startActivity(dessertActivityIntent);
        });


    }
}