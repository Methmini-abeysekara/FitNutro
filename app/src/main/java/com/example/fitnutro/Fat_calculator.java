package com.example.fitnutro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Fat_calculator extends AppCompatActivity {
    RadioButton radioButton,radioButton2;
    ImageView imageView;
    RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_calculator);


        imageView=findViewById(R.id.m_imaGeView);
        radioButton= findViewById(R.id.m_radioButton4);
        radioButton2=findViewById(R.id.m_radioButton5);
        radioGroup=findViewById(R.id.m_radioGroup);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.m_radioButton4:
                        imageView.setImageResource(R.drawable.fat_woman);
                        break;
                    case R.id.m_radioButton5:
                        imageView.setImageResource(R.drawable.fat_man);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}