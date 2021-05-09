package com.example.fitnutro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CalorieResult extends AppCompatActivity {
    //ImageButton backArr;
    ImageButton home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_result);

        home = findViewById(R.id.imageButton6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });


        /*backArr = (ImageButton) findViewById(R.id.BackArr);
        backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backTocalCal(); }
        });*/


    }

    public void backToHome(){
        Intent in = new Intent(CalorieResult.this,WelcomePage.class);
        startActivity(in);
    }

    /*public  void backTocalCal(){
        Intent in = new Intent(CalorieResult.this,CalorieCalculator.class);
        startActivity(in);
    }*/

}
