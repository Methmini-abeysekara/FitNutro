package com.example.fitnutro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeToTimetablePage extends AppCompatActivity {
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcometotimetablepage);

        button1 = (Button) findViewById(R.id.tstartedbtn);
        button2 = (Button) findViewById(R.id.wcalbtn);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opentimetable();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openweeklyworkouttime();
            }
        });
    }

    public void opentimetable(){
        Intent intent = new Intent(this, Timetable.class);
        startActivity(intent);
    }
    public void openweeklyworkouttime(){
        Intent intent = new Intent (this, WaterIntakeCalculator.class);
        startActivity(intent);
    }
}