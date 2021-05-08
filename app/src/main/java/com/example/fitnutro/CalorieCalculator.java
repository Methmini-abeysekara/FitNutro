package com.example.fitnutro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

public class CalorieCalculator extends AppCompatActivity {
    Button calculatebtn,calTablebtn;
    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView calresulttxt;
    EditText age;
    ImageButton home;
    //ImageButton backArr;

    String Calorieresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);

        /*backArr = (ImageButton) findViewById(R.id.BackArr); backArr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { backToMyProfile(); }
        });*/

        radioGroup = findViewById(R.id.radioGroup);
        age = findViewById(R.id.edtAge);

        //Spinner
        List<String> states = Arrays.asList("SEDENTARY","MODERATE","ACTIVE");
        Spinner mySpinner = (Spinner) findViewById(R.id.spinFitnesslvl);
        ArrayAdapter myAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.select_dialog_item, states);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String newItem = states.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        calculatebtn = (Button) findViewById(R.id.btnCalCalorie);
        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalorieResult();

                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                String states = mySpinner.getSelectedItem().toString();
            }
        });

        home = findViewById(R.id.imageButton6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToHome();
            }
        });

    }

    public void backToHome(){
        Intent in = new Intent(CalorieCalculator.this,WelcomePage.class);
        startActivity(in);
    }

    public void  openCalorieResult(){
        Intent in = new Intent(CalorieCalculator.this,CalorieResult.class);
        startActivity(in);
    }

    public void checkButton(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

    }

    /*public  void backToMyProfile(){
        Intent in = new Intent(CalorieCalculator.this,MyProfile.class);
        startActivity(in);
    }*/

    /*public void calculateCalorie(View view) {
        String S0 = radioButton.getText().toString();
        String S1 = age.getText().toString();
        String S3 = mySpinner.onItemSelected().toString();
        if(S0=="Female"){
            if(S1>=19 && S1<=30) {
                if (S3 == "SEDENTARY") {
                    Calorieresult =  "1800-2000";
                } else if (S3 == "MODERATE") {
                    Calorieresult =  "2000-2200";
                } else if(S3 == "ACTIVE"){
                    Calorieresult =  "2400";
                }
            }
            if(S1>=31 && S1<=50) {
                if (S3 == "SEDENTARY") {
                    Calorieresult =  "1800";
                } else if (S3 == "MODERATE") {
                    Calorieresult =  "2000";
                } else if(S3 == "ACTIVE"){
                    Calorieresult =  "2200";
                }
            }
            if(S1<=51) {
                if (S3 == "SEDENTARY") {
                    Calorieresult =  "1600";
                } else if (S3 == "MODERATE") {
                    Calorieresult =  "1800";
                } else if(S3 == "ACTIVE"){
                    Calorieresult =  "2000-2200";
                }
            }

        }
        else if(S0 =="Male"){
            if(S1>=19 && S1<=30) {
                if (S3 == "SEDENTARY") {
                    Calorieresult =  "2400-2600";
                } else if (S3 == "MODERATE") {
                    Calorieresult =  "2600-2800";
                } else if(S3 == "ACTIVE"){
                    Calorieresult =  "3000";
                }
            }
            if(S1>=31 && S1<=50) {
                if (S3 == "SEDENTARY") {
                    Calorieresult =  "2200-2400";
                } else if (S3 == "MODERATE") {
                    Calorieresult =  "2400-2600";
                } else if(S3 == "ACTIVE"){
                    Calorieresult =  "2800-3000";
                }
            }
            if(S1<=51) {
                if (S3 == "SEDENTARY") {
                    Calorieresult =  "2000-2200";
                } else if (S3 == "MODERATE") {
                    Calorieresult =  "2200-2400";
                } else if(S3 == "ACTIVE"){
                    Calorieresult =  "2400-2800";
                }
            }
        }


        Calorieresult = "Your Required Calories: \n\t" + Calorieresult;
        calresulttxt.setText(Calorieresult);
    }*/
}
