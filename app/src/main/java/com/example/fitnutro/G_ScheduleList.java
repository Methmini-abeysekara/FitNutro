package com.example.fitnutro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

public class G_ScheduleList extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;

    DatabaseHandler myDB;
    ArrayList<String> workout_id, workout_title, workout_description, workout_sets,workout_reps;
    CustomView customview;
    Button sample_gain_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_shedule_list);

        recyclerView = findViewById(R.id.W_recyclerView);
        add_button = findViewById(R.id.W_add_button);
        sample_gain_button = findViewById(R.id.W_sample_weightgain_button);


        sample_gain_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(G_ScheduleList.this,GainActivity.class);
                startActivity(intent);
            }
        });


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(G_ScheduleList.this, AddTask.class);
                startActivity(intent);
            }
        });

        myDB = new DatabaseHandler(G_ScheduleList.this);
        workout_id = new ArrayList<>();
        workout_title = new ArrayList<>();
        workout_description = new ArrayList<>();
        workout_sets = new ArrayList<>();
        workout_reps = new ArrayList<>();

        setDataToArray();

        customview = new CustomView(G_ScheduleList.this,this, workout_id, workout_title, workout_description,
                workout_sets,workout_reps);
        recyclerView.setAdapter(customview);
        recyclerView.setLayoutManager(new LinearLayoutManager(G_ScheduleList.this));

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void setDataToArray(){
        Cursor cursor = myDB.readData();
        if(cursor.getCount() == 0){

            Toasty.info(this,"No Data",Toast.LENGTH_LONG).show();
        }
        else{
            while(cursor.moveToNext()){
                workout_id.add(cursor.getString(0));
                workout_title.add(cursor.getString(1));
                workout_description.add(cursor.getString(2));
                workout_sets.add(cursor.getString(3));
                workout_reps.add(cursor.getString(4));

            }

        }
    }



}