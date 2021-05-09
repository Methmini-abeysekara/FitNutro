package com.example.fitnutro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class GainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gain);
        RecyclerView recyclerView = findViewById(R.id.W_recyclerView_gainList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MyWorkoutData[] myMovieData = new MyWorkoutData[]{
                new MyWorkoutData("Overhead Press",R.drawable.overhead_press),
                new MyWorkoutData("Push ups",R.drawable.push_ups),
                new MyWorkoutData("Deadlift",R.drawable.deadlift),
                new MyWorkoutData("Squats",R.drawable.squat),
                new MyWorkoutData("Pull ups",R.drawable.pull_ups),
        };

        MyWorkoutAdapter myWorkoutAdapter = new MyWorkoutAdapter(myMovieData,GainActivity.this);
        recyclerView.setAdapter(myWorkoutAdapter);

    }
}