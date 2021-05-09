package com.alpha.fitnutronew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartTarget extends AppCompatActivity {

    Button Gain_button,Loss_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_target);

        Gain_button = findViewById(R.id.W_gain_button);
        Gain_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StartTarget.this,G_ScheduleList.class);
                startActivity(i);
            }
        });
    }
}